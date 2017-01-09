package com.lewis.bohconfig.common.enumer;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public enum SwitchType {
    VAR_PARAM("varParam"),FUNCTION_SWITCH("functionSwitch");

    public SwitchType of(String switchType){
        SwitchType[] values = SwitchType.values();
        if (ArrayUtils.isNotEmpty(values)) {
            for (SwitchType value : values) {
                if (value.equals(switchType)) {
                    return value;
                }
            }
        }
        return VAR_PARAM;
    }


    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    SwitchType(String type) {
        this.type = type;
    }
}
