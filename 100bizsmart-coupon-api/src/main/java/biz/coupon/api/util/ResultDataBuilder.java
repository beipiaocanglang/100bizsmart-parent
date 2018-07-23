package biz.coupon.api.util;

import biz.coupon.api.model.bo.ResultData;

/**
 * Created by dev on 2018/4/7.
 */
public class ResultDataBuilder {

    //获取成功返回值
    public static <T>ResultData buildSuccessResultData(T t, Boolean status, Integer statusCode, String msg){

        ResultData<T> resultData = new ResultData<T>();
        resultData.setMsg(msg);
        resultData.setResult(t);
        resultData.setStatus(status);
        resultData.setStatusCode(statusCode);
        return resultData;
    }
    //获取失败或者异常返回值
    public static ResultData buildErrorResultData(String msg){
        ResultData resultData = new ResultData();

        resultData.setStatus(Boolean.FALSE);
        resultData.setStatusCode(500);
        resultData.setMsg(msg);
        resultData.setResult(null);
        return resultData;
    }

    public static ResultData buildErrorResultData(String msg,Integer errorCode){
        ResultData resultData = new ResultData();

        resultData.setStatus(Boolean.FALSE);
        resultData.setStatusCode(errorCode);
        resultData.setMsg(msg);
        resultData.setResult(null);
        return resultData;
    }
}
