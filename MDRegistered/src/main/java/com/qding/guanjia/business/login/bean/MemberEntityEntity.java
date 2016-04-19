package com.qding.guanjia.business.login.bean;


/**
 * Created by liuyonglong on 16/3/3.
 */
public class MemberEntityEntity extends BaseBean {
    private int gender;//性别
    private String headImg;//头像
    private String memberId;//会员ID
    private String mobile;//手机号
    private String name;//会员名称
    private int serviceStatus;//服务状态

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public int getGender() {
        return gender;
    }

    public String getHeadImg() {
        return headImg;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }
}
