package biz.coupon.api.model.bo;

/**
 * 调用接口查询单张券  入参值
 */
public class CoupScanParam {

    private String couponNo;//券码

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }
}
