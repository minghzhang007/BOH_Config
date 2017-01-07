package com.lewis.bohconfig.common.enumer;

/**
 * Created by zhangminghua on 2017/1/7.
 */
public enum FunctionSwitchEnum {
    ;
    private String identity;

    private String description;

    private boolean onOff;

    FunctionSwitchEnum(String identity, String description, boolean onOff) {
        this.identity = identity;
        this.description = description;
        this.onOff = onOff;
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

    @Override
    public String toString() {
        return "FunctionSwitchEnum{" +
                "identity='" + identity + '\'' +
                ", description='" + description + '\'' +
                ", onOff=" + onOff +
                '}';
    }
}
