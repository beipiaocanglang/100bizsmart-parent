package biz.coupon.api.model.bo;

/**
 * Created by dev on 2018/4/10.
 */
public class GetCouponVO {

    private String uid;//用户标识

    private String couponId;//活动Id

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
