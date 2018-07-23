package biz.coupon.api.model;

public class CouponDetailData extends BaseBO{

    private String uid;//用户ID

    private Long mid;//活动ID

    private String refPromotionCode;//活动编码，冗余一下，此值不作修改

    private String code;//券码WZ+15位随机数字

    private String createOn;

    private String payOn;

    private String cancelOn;

    private Integer state;//状态

    private String cancelBy;

    private String payBy;

    private String createBy;

    private String shopCode;//核销门店

    private String salesNo;//核销的小票号

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getRefPromotionCode() {
        return refPromotionCode;
    }

    public void setRefPromotionCode(String refPromotionCode) {
        this.refPromotionCode = refPromotionCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }

    public String getPayOn() {
        return payOn;
    }

    public void setPayOn(String payOn) {
        this.payOn = payOn;
    }

    public String getCancelOn() {
        return cancelOn;
    }

    public void setCancelOn(String cancelOn) {
        this.cancelOn = cancelOn;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCancelBy() {
        return cancelBy;
    }

    public void setCancelBy(String cancelBy) {
        this.cancelBy = cancelBy;
    }

    public String getPayBy() {
        return payBy;
    }

    public void setPayBy(String payBy) {
        this.payBy = payBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}