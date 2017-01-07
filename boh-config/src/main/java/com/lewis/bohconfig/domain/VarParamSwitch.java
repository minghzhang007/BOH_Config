package com.lewis.bohconfig.domain;

/**
 * Created by zhangminghua on 2017/1/7.
 */
public class VarParamSwitch {

    private Integer id;

    private String identity;

    private String description;

    private String content;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "VarParamSwitch{" +
                "id=" + id +
                ", identity='" + identity + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
