package biz.coupon.consume.controller;

import biz.coupon.api.dao.CouponMainDao;
import biz.coupon.api.model.CouponDetailData;
import biz.coupon.api.model.CouponMainData;
import biz.coupon.api.model.bo.ResultData;
import biz.coupon.api.service.DetailCouponService;
import biz.coupon.api.service.MainCouponService;
import biz.coupon.api.util.ResultDataBuilder;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/test/ccoup")
public class Test {

    //@RequestMapping(value = "test", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @RequestMapping(value = "test")
    @ResponseBody
    public ResultData test(){

        //List<CouponMainData> result =  couponMainDataMapper.selectByExample(new CouponMainDataExample());

        /*ResultDTO<List<CouponMainData>> resultDTO = new ResultDTO<List<CouponMainData>>();

        /*resultDTO.setData(result);

        ResultDTOBuilder.success(result);*/

        return ResultDataBuilder.buildSuccessResultData(new CouponDetailData(),Boolean.TRUE,200,"");
    }

    @PostMapping(value = "saveMainDataTest")
    @ResponseBody
    public ResultData saveMainData(@RequestBody CouponMainData couponMainData, HttpServletRequest request){
        try {
            couponMainData.setCreatedTime(new Date());
            couponMainData.setModifiedTime(new Date());

            mainCouponService.saveCouponMainData(couponMainData);

            if(couponMainData.getId()!=null){
                return ResultDataBuilder.buildSuccessResultData(couponMainData,Boolean.TRUE,200,"成功");
            }else{
                return ResultDataBuilder.buildErrorResultData("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDataBuilder.buildErrorResultData("插入异常");
        }
    }

    private Date convert(String stringDate) {
        if(StringUtils.isEmpty(stringDate)){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "saveDetailDataTest")
    @ResponseBody
    public ResultData saveDetailDataTest(@RequestBody CouponDetailData couponDetailData){
        try {
            couponDetailData.setCreatedTime(new Date());
            couponDetailData.setModifiedTime(new Date());
            detailCouponService.saveCouponDetailData(couponDetailData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultDataBuilder.buildSuccessResultData(couponDetailData,Boolean.TRUE,200,"成功");
    }

    @GetMapping(value = "index1")
    public String index(){
        return "test";
    }

    /**
     * 接下来是测试类
     */

    @Resource
    private DetailCouponService detailCouponService;

    @Resource
    private MainCouponService mainCouponService;

    //时间格式化
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "testHttpClient")
    public void testHttpClient() {

        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://47.94.153.196:8080/api/ccoup/getmycouponlist");
            //创建一个提交数据的容器
            JSONObject json = new JSONObject();
            json.put("uid","111");
            StringEntity s = new StringEntity(json.toString(),"utf-8");
            //封装容器到请求参数中
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            //设置请求参数到post请求中
            httpPost.setEntity(s);
            httpPost.setHeader("Content-Type", "application/json");
            //执行post请求
            HttpResponse response = client.execute(httpPost);

            System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Resource
    private ExpireJobTask expireJobTask;

    @GetMapping(value = "excuteTime")
    @ResponseBody
    public ResultData excuteTime(){

        expireJobTask.doJob();

        return ResultDataBuilder.buildSuccessResultData(null,true,200,"");
    }
}
