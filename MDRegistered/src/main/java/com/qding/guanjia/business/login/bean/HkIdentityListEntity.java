package com.qding.guanjia.business.login.bean;


import com.qianding.sdk.framework.bean.BaseBean;

/**
 * 身份职责
 * Created by liuyonglong on 16/3/3.
 */
public class HkIdentityListEntity extends BaseBean {
    private String identityId;//身份ID
    private String identityName;//身份名称

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getIdentityId() {
        return identityId;
    }

    public String getIdentityName() {
        return identityName;
    }
}
