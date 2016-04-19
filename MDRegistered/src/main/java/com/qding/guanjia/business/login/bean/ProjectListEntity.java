package com.qding.guanjia.business.login.bean;


import java.util.List;

/**
 * 社区信息列表
 * Created by liuyonglong on 16/3/3.
 */
public class ProjectListEntity extends BaseBean {
    private String cityId;//所属城市ID
    private String cityName;//所属城市名称
    private String id;//社区ID
    private String name;//社区名称
    private List<ProjectConcatEntity> concats;//社区联系信息
    private List<ProjectGroupEntity> groups;//社区所属组织信息

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConcats(List<ProjectConcatEntity> concats) {
        this.concats = concats;
    }

    public void setGroups(List<ProjectGroupEntity> groups) {
        this.groups = groups;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProjectConcatEntity> getConcats() {
        return concats;
    }

    public List<ProjectGroupEntity> getGroups() {
        return groups;
    }
}
