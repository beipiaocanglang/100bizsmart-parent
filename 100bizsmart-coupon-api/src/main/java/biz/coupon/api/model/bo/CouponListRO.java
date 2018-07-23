package biz.coupon.api.model.bo;

/**
 * Created by dev on 2018/4/11.
 */
public class CouponListRO {

    private String name;//活动名称

    private String desc;//活动描述

    private String couponId;//券Id或活动ID

    private String begin;// 开始时间

    private String end;//结束时间

    private String couponCode;//券code

    private Integer couponStatus;//券状态

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
