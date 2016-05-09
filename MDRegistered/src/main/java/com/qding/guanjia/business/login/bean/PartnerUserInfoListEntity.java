package com.qding.guanjia.business.login.bean;


import com.qianding.sdk.framework.bean.BaseBean;

/**
 * 账户来源信息
 * Created by liuyonglong on 16/3/3.
 */
public class PartnerUserInfoListEntity extends BaseBean {
    private String partnerId;//来源ID
    private String partnerType;//来源类型[bs:boss后台(puserId),cw:财务,wy:物业(wyPersonId),sh:商户,hk:管家]

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getPartnerType() {
        return partnerType;
    }
}
