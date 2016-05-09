package com.qding.guanjia.business.login.bean;


import com.qianding.sdk.framework.bean.BaseBean;

/**
 * Created by liuyonglong on 16/3/3.
 */
public class AccountEntityEntity extends BaseBean {
    private String accountId;//账号ID
    private String nickName;//昵称
    private String rongCloudToken;//融云Token
    private int sourceType;//账号来源
    private int status;//账号状态
    private int type;//账号类型

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setRongCloudToken(String rongCloudToken) {
        this.rongCloudToken = rongCloudToken;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getNickName() {
        return nickName;
    }

    public String getRongCloudToken() {
        return rongCloudToken;
    }

    public int getSourceType() {
        return sourceType;
    }

    public int getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }
}
