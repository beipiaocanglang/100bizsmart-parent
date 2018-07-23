package biz.coupon.api.model.bo;

import java.util.Set;

/**
 * 调用接口查询单张券 返回值
 */
public class CoupScanRO {

    private String couponNo;//券主键ID detail

    //private String couponCode;//券码 detail

    private String couponType;//券类型 main

    private String couponTypeDesc;//券类型中文

    private String couponName;//券名称（活动名称） main

    private String begDate;//开始时间 main

    private String endDate;//结束时间 main

    private Double capital;//本金（当券类型为代金券时有效） main

    private Double faceValue;//面值（当券类型为代金券时有效）main

    private Double threshold;//门槛（当券类型为满减券时有效）main

    private Double exemption;//免减金额（当券类型为满减券时有效）main

    private String guide;//使用说明 main

    private Integer availableNum;//同一券种编码下的券可用数量,当前用户的

    private Set<String> availableCoupons;//当AvailableNum 大于1时此字段有效 (券码集合)

    private String promotionCode;//券种编码(活动编码) main

    private Integer code;//券状态码 detail
    //  200:有效201:验证失败202:券号不存在204:已使用过的消费券205:消费券不在有效期220:券不可使用(例如：锁定、禁用)

    private String message;//描述 unknown

    private String shopCode;//门店ID

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    /*public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }*/

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponTypeDesc() {
        return couponTypeDesc;
    }

    public void setCouponTypeDesc(String couponTypeDesc) {
        this.couponTypeDesc = couponTypeDesc;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Double faceValue) {
        this.faceValue = faceValue;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public Double getExemption() {
        return exemption;
    }

    public void setExemption(Double exemption) {
        this.exemption = exemption;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public Integer getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(Integer availableNum) {
        this.availableNum = availableNum;
    }

    public Set<String> getAvailableCoupons() {
        return availableCoupons;
    }

    public void setAvailableCoupons(Set<String> availableCoupons) {
        this.availableCoupons = availableCoupons;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
