package biz.wfj.smallprogram.api.model;

import faner.dplatformSpringjdbc.api.frame.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author : lijianjun
 * @version V2.0
 * @Company: faner
 */
@SuppressWarnings("serial")
public class DfieldCheck extends BaseModel {

    // 字段
    //columns START
    private Long id;
    private String name;
    private String regular;
    private String ownedBusiness;
    private String remarks;
    private String delFlg;
    private String insUser;
    private java.util.Date insTime;
    private String updUser;
    private java.util.Date updTime;
    //columns END

    // 属性get,set
    public void setId(Long value) {
        this.id = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setRegular(String value) {
        this.regular = value;
    }

    public String getRegular() {
        return this.regular;
    }

    public void setOwnedBusiness(String value) {
        this.ownedBusiness = value;
    }

    public String getOwnedBusiness() {
        return this.ownedBusiness;
    }

    public void setRemarks(String value) {
        this.remarks = value;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setDelFlg(String value) {
        this.delFlg = value;
    }

    public String getDelFlg() {
        return this.delFlg;
    }

    public void setInsUser(String value) {
        this.insUser = value;
    }

    public String getInsUser() {
        return this.insUser;
    }

    public void setInsTime(java.util.Date value) {
        this.insTime = value;
    }

    public java.util.Date getInsTime() {
        return this.insTime;
    }

    public void setUpdUser(String value) {
        this.updUser = value;
    }

    public String getUpdUser() {
        return this.updUser;
    }

    public void setUpdTime(java.util.Date value) {
        this.updTime = value;
    }

    public java.util.Date getUpdTime() {
        return this.updTime;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("Id", getId())
                .append("Name", getName())
                .append("Regular", getRegular())
                .append("OwnedBusiness", getOwnedBusiness())
                .append("Remarks", getRemarks())
                .append("DelFlg", getDelFlg())
                .append("InsUser", getInsUser())
                .append("InsTime", getInsTime())
                .append("UpdUser", getUpdUser())
                .append("UpdTime", getUpdTime())
                .toString();
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DfieldCheck == false) return false;
        if (this == obj) return true;
        DfieldCheck other = (DfieldCheck) obj;
        return new EqualsBuilder()
                .append(getId(), other.getId())
                .isEquals();
    }
}

