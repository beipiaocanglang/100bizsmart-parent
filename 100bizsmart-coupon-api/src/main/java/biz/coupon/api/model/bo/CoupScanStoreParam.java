package biz.coupon.api.model.bo;

/**
 * Created by dev on 2018/4/12.
 */
public class CoupScanStoreParam {
    private String couponNo;//券码

    private String shopCode;//门店ID

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }
}
