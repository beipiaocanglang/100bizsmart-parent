package biz.coupon.api.util;

/**
 * Created by dev on 2018/4/17.
 */
public enum MainDataStatus {

    NORMAL(200,"活动正常"),
    STOP(405,"活动停止");

    MainDataStatus(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static MainDataStatus getByValue(Integer value) {
        for (MainDataStatus type : MainDataStatus.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }

    private Integer value;
    private String desc;

    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
