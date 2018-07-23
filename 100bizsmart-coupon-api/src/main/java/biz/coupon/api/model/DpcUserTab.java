package biz.coupon.api.model;

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
public class DpcUserTab extends BaseModel {

    // 字段
    //columns START
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String realName;
    private String leadersTel;
    private String mailAddress;
    private String address;
    private String userType;
    private String remarks;
    private String controlConfirmFlg;
    private String companyId;
    private String roleId;
    private String delFlg;
    private String insUser;
    private java.util.Date insTime;
    private String updUser;
    private java.util.Date updTime;
    private String reserveCol1;
    private String reserveCol2;
    private String reserveCol3;
    private String reserveCol4;
    private String reserveCol5;
    //columns END

    // 属性get,set
    public void setId(Long value) {
        this.id = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setUserId(String value) {
        this.userId = value;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserName(String value) {
        this.userName = value;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setRealName(String value) {
        this.realName = value;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setLeadersTel(String value) {
        this.leadersTel = value;
    }

    public String getLeadersTel() {
        return this.leadersTel;
    }

    public void setMailAddress(String value) {
        this.mailAddress = value;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getAddress() {
        return this.address;
    }

    public void setUserType(String value) {
        this.userType = value;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setRemarks(String value) {
        this.remarks = value;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setControlConfirmFlg(String value) {
        this.controlConfirmFlg = value;
    }

    public String getControlConfirmFlg() {
        return this.controlConfirmFlg;
    }

    public void setCompanyId(String value) {
        this.companyId = value;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setRoleId(String value) {
        this.roleId = value;
    }

    public String getRoleId() {
        return this.roleId;
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

    public void setReserveCol1(String value) {
        this.reserveCol1 = value;
    }

    public String getReserveCol1() {
        return this.reserveCol1;
    }

    public void setReserveCol2(String value) {
        this.reserveCol2 = value;
    }

    public String getReserveCol2() {
        return this.reserveCol2;
    }

    public void setReserveCol3(String value) {
        this.reserveCol3 = value;
    }

    public String getReserveCol3() {
        return this.reserveCol3;
    }

    public void setReserveCol4(String value) {
        this.reserveCol4 = value;
    }

    public String getReserveCol4() {
        return this.reserveCol4;
    }

    public void setReserveCol5(String value) {
        this.reserveCol5 = value;
    }

    public String getReserveCol5() {
        return this.reserveCol5;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("Id", getId())
                .append("UserId", getUserId())
                .append("Password", getPassword())
                .append("UserName", getUserName())
                .append("RealName", getRealName())
                .append("LeadersTel", getLeadersTel())
                .append("MailAddress", getMailAddress())
                .append("Address", getAddress())
                .append("UserType", getUserType())
                .append("Remarks", getRemarks())
                .append("ControlConfirmFlg", getControlConfirmFlg())
                .append("CompanyId", getCompanyId())
                .append("RoleId", getRoleId())
                .append("DelFlg", getDelFlg())
                .append("InsUser", getInsUser())
                .append("InsTime", getInsTime())
                .append("UpdUser", getUpdUser())
                .append("UpdTime", getUpdTime())
                .append("ReserveCol1", getReserveCol1())
                .append("ReserveCol2", getReserveCol2())
                .append("ReserveCol3", getReserveCol3())
                .append("ReserveCol4", getReserveCol4())
                .append("ReserveCol5", getReserveCol5())
                .toString();
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DpcUserTab == false) return false;
        if (this == obj) return true;
        DpcUserTab other = (DpcUserTab) obj;
        return new EqualsBuilder()
                .append(getId(), other.getId())
                .isEquals();
    }
}

