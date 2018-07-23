package biz.coupon.api.model;

public class CouponMainData extends BaseBO {

    private String rid;//Unknown

    private String promotionCode;//活动编码

    private String name;//活动名称

    private String type;//活动类型
    private String typeDesc;//活动类型描述

    private Double capital;//本金（当券类型为代金券时有效）

    private Double faceValue;//面值（当券类型为代金券时有效）

    private Double threshold;//门槛（当券类型为满减券时有效）

    private Double exemption;//免减金额（当券类型为满减券时有效）

    private String beginDate;//有效开始日期
    private String endDate;//有效结束日期

    private Integer state;//状态
    private String stateDesc;//状态描述

    private String createdon;

    private Integer countMax;// 活动总发放券总数

    private Integer userCountMax;// 单个用户可领券总数

    private String processer;

    private String guide;//使用说明

    private String storeId;//门店

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public Integer getCountMax() {
        return countMax;
    }

    public void setCountMax(Integer countMax) {
        this.countMax = countMax;
    }

    public Integer getUserCountMax() {
        return userCountMax;
    }

    public void setUserCountMax(Integer userCountMax) {
        this.userCountMax = userCountMax;
    }

    public String getProcesser() {
        return processer;
    }

    public void setProcesser(String processer) {
        this.processer = processer;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}