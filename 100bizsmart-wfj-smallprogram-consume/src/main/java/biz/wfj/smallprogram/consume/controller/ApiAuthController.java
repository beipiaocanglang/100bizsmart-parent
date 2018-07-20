package biz.wfj.smallprogram.consume.controller;

import biz.consume.frame.controller.BaseController;
import biz.wfj.smallprogram.api.model.FullUserInfo;
import biz.wfj.smallprogram.api.model.UserInfo;
import biz.wfj.smallprogram.api.model.UserVo;
import biz.wfj.smallprogram.api.service.ApiUserService;
import biz.wfj.smallprogram.api.service.TokenService;
import biz.wfj.smallprogram.api.util.CharUtil;
import biz.wfj.smallprogram.api.util.MyX509TrustManager;
import biz.wfj.smallprogram.api.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.security.InvalidKeyException;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(ApiAuthController.class);
    @Resource
    private ApiUserService userService;
    @Resource
    private TokenService tokenService;
    @Autowired
    protected HttpServletRequest request;

    /**
     * 登录
     */
    @RequestMapping("login_by_weixin")
    public Object loginByWeixin() throws Base64DecodingException {
        JSONObject jsonParam = this.getJsonRequest();

        FullUserInfo fullUserInfo = null;
        String code = "";
        if (!StringUtils.isNullOrEmpty(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }
        if (null != jsonParam.get("userInfo")) {
            fullUserInfo = jsonParam.getObject("userInfo", FullUserInfo.class);
        }

        Map<String, Object> resultObj = new HashMap();
        UserInfo userInfo = fullUserInfo.getUserInfo();
        //获取openid
        String requestUrl = this.getWebAccess(code);//通过自定义工具类组合出小程序需要的登录凭证 code
        logger.info("》》》组合token为：" + requestUrl);
        JSONObject sessionData = this.httpsRequest(requestUrl, "GET", null);

        if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("openid"))) {
            return this.toResponsFail("登录失败");
        }
        //验证用户信息完整性
        String sha1 = this.getSha1(fullUserInfo.getRawData() + sessionData.getString("session_key"));
        if (!fullUserInfo.getSignature().equals(sha1)) {
            return toResponsFail("登录失败");
        }

        if(StringUtils.isNullOrEmpty(fullUserInfo.getEncryptedData()) || StringUtils.isNullOrEmpty(fullUserInfo.getIv())){
            return toResponsFail("登录失败");
        }

        //获取UnionId
        byte[] encrypData = Base64.decode(fullUserInfo.getEncryptedData());
        byte[] ivData = Base64.decode(fullUserInfo.getIv());
        byte[] sessionKey =Base64.decode(sessionData.getString("session_key"));
        String rtn = "";
        JSONObject json =null;
        try {
            rtn = this.decrypt(sessionKey, ivData, encrypData);
            json = JSONObject.parseObject(rtn);
            if(json==null || StringUtils.isNullOrEmpty(json.getString("unionId"))){
                return toResponsFail("登录失败");
            }
        }catch(Exception e ){
            e.printStackTrace();
        }

        String openId = sessionData.getString("openid");
        String unionid = json.getString("unionId");
        String session_key = sessionData.getString("session_key");

        Map token = tokenService.createLoginToken(openId,unionid,session_key);

        Date nowTime = new Date();
        Map<String, Object> paramsMap = new LinkedHashMap<>();
        paramsMap.put("openId", openId);
        UserVo userVo = userService.queryByOpenId(paramsMap);
        if (null == userVo) {
            userVo = new UserVo();
            userVo.setUsername("微信用户" + CharUtil.getRandomString(12));
            userVo.setPassword(openId);
            userVo.setRegister_time(nowTime);
            userVo.setRegister_ip(this.getClientIp());
            userVo.setLast_login_ip(userVo.getRegister_ip());
            userVo.setLast_login_time(userVo.getRegister_time());
            userVo.setWeixin_openid(openId);
            userVo.setUnion_id(unionid);
            userVo.setAvatar(userInfo.getAvatarUrl());
            userVo.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(userInfo.getNickName());
            userVo.setCity(userInfo.getCity());
            userVo.setCountry(userInfo.getCountry());
            userVo.setProvince(userInfo.getProvince());
            userVo.setCity(userInfo.getCity());
            userVo.setLanguage(userInfo.getLanguage());
            userService.save(userVo);
        } else {
            userVo.setLast_login_ip(this.getClientIp());
            userVo.setLast_login_time(nowTime);
            userService.update(userVo);
        }
        userInfo.setUnionId(unionid);
        userInfo.setOpenId(openId);
        userInfo.setWxCard(userVo.getWxCard());
        userInfo.setStoreCode(userVo.getStoreCode());
        //取卡信息
        String mobile = "";
        if (!StringUtils.isNullOrEmpty(userVo.getMobile())) {
            mobile = userVo.getMobile();
            userInfo.setMobile(mobile);

            Map cardInfo = userService.get_user_info(mobile);
            resultObj.put("cardTotalCnt",cardInfo.get("cardTotalCnt"));
            resultObj.put("bindCardList",cardInfo.get("bindCardList"));
            resultObj.put("unBindCardList",cardInfo.get("unBindCardList"));
            resultObj.put("bindCardCnt",cardInfo.get("bindCardCnt"));
            resultObj.put("unbindCardCnt",cardInfo.get("unbindCardCnt"));
        }

        resultObj.put("token", token.get("token"));
        resultObj.put("userInfo" , userInfo);

        return toResponsSuccess(resultObj);
    }

    public JSONObject getJsonRequest() {
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //替换字符串
    public String getWebAccess(String CODE) {
        return String.format(this.getConfigByName("wx.webAccessTokenhttps"),
                this.getConfigByName("wx.appId"),
                this.getConfigByName("wx.secret"),
                CODE);
    }
    private static ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("platform");
    /**
     * 主要功能:获取配置文件参数
     * 注意事项:无
     * @param name 参数名称
     * @return 参数名称对应值
     */
    public static String getConfigByName(String name) {
        String value = "";
        try {
            value = new String(BUNDLE.getString(name).getBytes("iso8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
    /**
     * @param requestCode
     * @param msg
     * @param data
     * @return Map<String,Object>
     * @throws
     * @Description:构建统一格式返回对象
     * @date 2016年9月2日
     * @author zhuliyun
     */
    public Map<String, Object> toResponsObject(int requestCode, String msg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", requestCode);
        obj.put("msg", msg);
        if (data != null)
            obj.put("data", data);
        return obj;
    }
    public Map<String, Object> toResponsFail(String msg) {
        return toResponsObject(1, msg, null);
    }

    /**
     * 发送https请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);

            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("连接超时：{}", ce);
        } catch (Exception e) {
            logger.error("https请求异常：{}", e);
        }
        return jsonObject;
    }
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    public static String decrypt(byte[] key, byte[] iv, byte[] encData)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] original = cipher.doFinal(encData);
        String originalString = new String(original,"UTF-8");
        return originalString;
    }

    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    public String getClientIp() {
        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return request.getRemoteAddr();
        }
        return xff;
    }

    public Map<String, Object> toResponsSuccess(Object data) {
        Map<String, Object> rp = toResponsObject(0, "执行成功", data);
        logger.info("response:" + rp);
        return rp;
    }
}
