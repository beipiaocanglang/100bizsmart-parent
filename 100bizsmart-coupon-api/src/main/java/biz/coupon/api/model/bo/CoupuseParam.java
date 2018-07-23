package biz.coupon.api.model.bo;

/**
 * Created by dev on 2018/4/11.
 */
public class CoupuseParam {

    private String shopCode;//核销门店

    private String salesNo;//核销的小票号

    private String couponNo;//券码

    private Integer couponNum;//需要核销的数量

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(String salesNo) {
        this.salesNo = salesNo;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public Integer getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(Integer couponNum) {
        this.couponNum = couponNum;
    }
}
