package com.qding.guanjia.business.login.bean;


/**
 * 社区所属信息
 * Created by liuyonglong on 16/3/8.
 */
public class ProjectGroupEntity extends BaseBean {
    private String groupCode;//社区分组Code
    private String groupName;//社区分组名称

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
