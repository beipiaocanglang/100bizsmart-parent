package biz.wfj.smallprogram.core.service.impl;

import biz.wfj.smallprogram.api.dao.ApiUserDao;
import biz.wfj.smallprogram.api.dao.ApiUserLevelDao;
import biz.wfj.smallprogram.api.model.DpcUserTab;
import biz.wfj.smallprogram.api.model.UserVo;
import biz.wfj.smallprogram.api.model.WxTokenEntity;
import biz.wfj.smallprogram.api.service.ApiUserService;
import biz.wfj.smallprogram.api.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wfj.member.sdk.client.ApiClient;
import com.wfj.member.sdk.common.ApiResultDTO;
import faner.dplatformSpringjdbc.api.frame.command.db.springJDBC.xml.OverallSituationStatic;
import faner.dplatformSpringjdbc.api.frame.util.tools.velocity.VelocityCoreUtils;
import faner.dplatformSpringjdbc.core.frame.service.impl.GenericNamedServiceImpl;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.druid.support.json.JSONUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiUserServiceImpl extends GenericNamedServiceImpl<UserVo, Long> implements ApiUserService {
    Logger logger = org.apache.log4j.Logger.getLogger(ApiUserService.class);
    private ApiUserDao userDao;
    private ApiUserLevelDao apiUserLevelDao;
    public ApiUserServiceImpl(ApiUserDao dao,ApiUserLevelDao dao1) {
        super(dao);
        this.userDao = dao;
        this.apiUserLevelDao = dao1;
    }
    public UserVo queryByOpenId(Map<String, Object> paramsMap) {
        Map<String, String> sqlMap = OverallSituationStatic.getTableAllSql(UserVo.class.getSimpleName());
        UserVo findByObj = (UserVo) this.userDao.findOneByMap(VelocityCoreUtils.render(sqlMap.get("findByObj"), paramsMap), paramsMap);
        return findByObj;
        //return userDao.queryByOpenId(openId);
    }

    public Map get_user_info(String mobile){

        Map<String, Object> data = new HashMap();

        //王府井获取会员卡列表
        String methodName = "api.getCardList";
        Map<String,String> wfjMap = new HashMap();

        wfjMap.put("mobile", mobile);

        String wfjParam = JSONUtils.toJSONString(wfjMap);
        ApiResultDTO res = ApiClient.submit(methodName, wfjParam);
        ApiResultDTO resMember = null;
        logger.info("》》》王府井卡列表接口  HTTP POST");
        logger.info("》》》方法名 ： api.getCardList");
        logger.info("》》》入参 ： "+wfjParam);
        logger.info("》》》ApiResultDTO  res.getSuccess()  :  " + res.getSuccess());
        logger.info("》》》ApiResultDTO  res.getErrMsg()  :  " + res.getErrMsg());
        logger.info("》》》ApiResultDTO  res.getErrCode()  :  " + res.getErrCode());
        logger.info("》》》ApiResultDTO  res.getData() : " + res.getData());
        String errCode = "";
        String errorMsg = "";

        Map bindCardMap = null;//已绑定卡列表
        Map unBindCardMap = null;//未绑定卡列表
        List bindCardList = new ArrayList();
        List unBindCardList = new ArrayList();

        //获取卡列表成功
        if (res.getSuccess() && !StringUtils.isNullOrEmpty(res.getData())) {

            String resCardList = JSONUtils.toJSONString(res.getData());
            JSONArray jsonArray = JSON.parseArray(resCardList);

            for (int i = 0; i < jsonArray.size(); i++) {
                Map resCardListMap = new HashMap();
                resCardListMap = (JSONObject) jsonArray.get(i);
                if (!StringUtils.isNullOrEmpty(resCardListMap)) {

                    methodName = "api.getMemberInfo";
                    wfjMap.clear();
                    wfjMap.put("mobile", mobile);
                    wfjMap.put("cid", (String) resCardListMap.get("cid"));
                    wfjMap.put("cardNo", (String) resCardListMap.get("cardNo"));
                    wfjParam = JSONUtils.toJSONString(wfjMap);
                    resMember = ApiClient.submit(methodName, wfjParam);

                    logger.info("》》》王府井卡明细接口  HTTP POST");
                    logger.info("》》》方法名 ： api.getMemberInfo");
                    logger.info("》》》入参 ： "+wfjParam);
                    logger.info("》》》ApiResultDTO  resMember.getSuccess()  :  " + resMember.getSuccess());
                    logger.info("》》》ApiResultDTO  resMember.getErrMsg()  :  " + resMember.getErrMsg());
                    logger.info("》》》ApiResultDTO  resMember.getErrCode()  :  " + resMember.getErrCode());
                    logger.info("》》》ApiResultDTO  resMember.getData() : " + resMember.getData());

                    Map memberMap = new HashMap();
                    bindCardMap = new HashMap();
                    unBindCardMap = new HashMap();

                    //获取卡明细成功
                    if (resMember.getSuccess()) {

                        String memberInfo = JSONUtils.toJSONString(resMember.getData());
                        memberMap = (Map) JSON.parseObject(memberInfo);
                        bindCardMap.put("cid", memberMap.get("cid"));
                        bindCardMap.put("storeCode", memberMap.get("storeCode"));
                        bindCardMap.put("storeName", memberMap.get("storeName"));
                        bindCardMap.put("cardLevel", memberMap.get("cardLevel"));
                        bindCardMap.put("cardLevelName", memberMap.get("cardLevelName"));
                        bindCardMap.put("mindate", memberMap.get("mindate"));
                        bindCardMap.put("cardNo", memberMap.get("cardNo"));
                        bindCardMap.put("qrcode", memberMap.get("qrcode"));
                        bindCardMap.put("switched", memberMap.get("switched"));
                        bindCardMap.put("hasNonCard", memberMap.get("hasNonCard"));
                        bindCardList.add(bindCardMap);
                    }
                } else {//获取卡明细失败
                    unBindCardMap.put("cid", resCardListMap.get("cid"));
                    unBindCardMap.put("cardNo", resCardListMap.get("cardNo"));
                    unBindCardMap.put("errorCode", resMember.getErrCode());
                    unBindCardMap.put("errorMsg", resMember.getErrMsg());
                    unBindCardList.add(unBindCardMap);
                }

            }
            data.put("cardTotalCnt", jsonArray.size());//卡总数
            data.put("bindCardList", bindCardList);//已绑卡列表
            data.put("unBindCardList", unBindCardList);//未绑卡列表
            data.put("bindCardCnt", bindCardList.size());//已绑卡总数
            data.put("unbindCardCnt", unBindCardList.size());//未绑卡总数
        }
        return data;
    }
}
