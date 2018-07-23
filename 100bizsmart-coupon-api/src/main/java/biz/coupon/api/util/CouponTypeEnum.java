package biz.coupon.api.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 券类型枚举
 */
public enum CouponTypeEnum {

    DJ("DJ","品牌代金券"),
    ZK("ZK","品牌折扣券"),
    CX("CX","品牌促销券"),
    LP("LP","礼品券"),
    YQ("YQ","邀请券"),
    YY("YY","异业券");

    CouponTypeEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CouponTypeEnum getCouponTypeEnumByCode(String code){
        if(StringUtils.isEmpty(code)){
            return null;
        }
        for (CouponTypeEnum couponTypeEnum : CouponTypeEnum.values()) {
            if(couponTypeEnum.getCode().equals(code)){
                return couponTypeEnum;
            }
        }
       return null;
    }
}
