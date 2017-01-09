package com.lewis.bohconfig.domain;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class SwitchRequestParam {
    private String swithType;

    private String identity;

    private String description;

    private String context;

    private boolean onOff;

    public String getSwithType() {
        return swithType;
    }

    public void setSwithType(String swithType) {
        this.swithType = swithType;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public SwitchRequestParam() {
    }

    @Override
    public String toString() {
        return "SwitchRequestParam{" +
                "swithType='" + swithType + '\'' +
                ", identity='" + identity + '\'' +
                ", description='" + description + '\'' +
                ", context='" + context + '\'' +
                ", onOff=" + onOff +
                '}';
    }
}
