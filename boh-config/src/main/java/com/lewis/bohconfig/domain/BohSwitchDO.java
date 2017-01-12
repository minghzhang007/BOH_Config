package com.lewis.bohconfig.domain;

/**
 * Created by zhangminghua on 2017/1/12.
 */
public class BohSwitchDO {
    private Integer id;

    private String identity;

    private Integer level;

    private String content;

    private String serviceName;

    private Integer bussinessType;

    private String mark;

    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(Integer bussinessType) {
        this.bussinessType = bussinessType;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public BohSwitchDO() {
    }

    @Override
    public String toString() {
        return "BohSwitchDO{" +
                "id=" + id +
                ", identity='" + identity + '\'' +
                ", level=" + level +
                ", content='" + content + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", bussinessType='" + bussinessType + '\'' +
                ", mark='" + mark + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
