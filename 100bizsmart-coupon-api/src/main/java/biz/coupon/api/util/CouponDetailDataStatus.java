package biz.coupon.api.util;

/**
 * Created by dev on 2018/4/11.
 */
public enum  CouponDetailDataStatus {

    STATUS_200(200,"ok","券可用"),
    STATUS_201(201,"fail","验证失败"),
    STATUS_202(202,"not_exist","券号不存在"),
    STATUS_204(204,"used","券已被使用"),
    STATUS_205(205,"passed","券不在有效期内"),
    STATUS_206(206,"written","已核销"),
    STATUS_300(300,"reversal","已冲正");

    CouponDetailDataStatus(Integer code,String value,String desc){
        this.code = code;
        this.value = value;
        this.desc = desc;
    }
    private Integer code;

    private String value;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CouponDetailDataStatus getCouponDetailDataStatusByCode(Integer code){
        if(code == null){
            return  null;
        }
        for (CouponDetailDataStatus couponDetailDataStatus : CouponDetailDataStatus.values()) {
            if(couponDetailDataStatus.getCode() == code){
                return couponDetailDataStatus;
            }
        }
        return null;
    }
    public static String getCouponDetailDataStatusDescByCode(Integer code){
        if(code == null){
            return  null;
        }
        for (CouponDetailDataStatus couponDetailDataStatus : CouponDetailDataStatus.values()) {
            if(couponDetailDataStatus.getCode() == code){
                return couponDetailDataStatus.getDesc();
            }
        }
        return null;
    }

}
