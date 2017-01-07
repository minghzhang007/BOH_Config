package com.lewis.bohconfig.domain;

/**
 * Created by zhangminghua on 2017/1/7.
 */
public class FunctionSwtich {
    private Integer id;

    private String identity;

    private String description;

    private boolean onOff;

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

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "FunctionSwtich{" +
                "id=" + id +
                ", identity='" + identity + '\'' +
                ", description='" + description + '\'' +
                ", onOff=" + onOff +
                ", delFlag=" + delFlag +
                '}';
    }
}
