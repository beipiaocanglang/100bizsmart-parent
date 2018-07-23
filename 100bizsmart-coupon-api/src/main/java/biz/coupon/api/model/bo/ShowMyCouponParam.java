package biz.coupon.api.model.bo;

/**
 * Created by dev on 2018/4/11.
 */
public class ShowMyCouponParam {

    private String uid;

    private String couponCodeId;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCouponCodeId() {
        return couponCodeId;
    }

    public void setCouponCodeId(String couponCodeId) {
        this.couponCodeId = couponCodeId;
    }
}
