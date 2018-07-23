package biz.coupon.api.model;

import java.util.Date;

/**
 * 基础BO
 */
public class BaseBO extends BaseModel {

    /** 主键ID */
    protected Long id;

    /** 创建时间 */
    protected Date createdTime;

    /** 更新时间 */
    protected Date modifiedTime;

    /** 逻辑删除标记; 0-未删除，1-已删除 */
    protected String isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
