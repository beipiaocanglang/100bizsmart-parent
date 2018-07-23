package biz.coupon.api.model.bo;

/**
 * 系统级返回对象
 * Created by dev on 2018/4/7.
 */
public class ResultData<T> {

    private Boolean status; //"status": true

    private Integer statusCode;//"statusCode": 200

    private String msg;//"msg": "成功"

    private T result;//"result": 见业务返回结果示例

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
