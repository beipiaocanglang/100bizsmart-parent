package biz.wfj.smallprogram.api.model;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_token
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-05-22 10:53:14
 */
public class WxTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String openId;
    //
    private String unionId;
    //
    private String sessionKey;
    //
    private String token;
    //
    private Date expireTime;
    //
    private Date updateTime;

    /**
     * 设置：
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取：
     */
    public String getOpenId() {
        return openId;
    }
    /**
     * 设置：
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取：
     */
    public String getUnionId() {
        return unionId;
    }
    /**
     * 设置：
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * 获取：
     */
    public String getSessionKey() {
        return sessionKey;
    }
    /**
     * 设置：
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取：
     */
    public String getToken() {
        return token;
    }
    /**
     * 设置：
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取：
     */
    public Date getExpireTime() {
        return expireTime;
    }
    /**
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }
}
