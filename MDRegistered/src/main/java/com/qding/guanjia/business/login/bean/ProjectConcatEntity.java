package com.qding.guanjia.business.login.bean;


import com.qianding.sdk.framework.bean.BaseBean;

import java.util.List;

/**
 *社区联系信息
 * Created by liuyonglong on 16/3/8.
 */
public class ProjectConcatEntity extends BaseBean {
    private String id;//联系ID
    private String type;//电话类型
    private String phone;//电话
    private List<String> phones;
    private String address;//地址
    private String postCode;//邮编

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
