package com.lewis.bohconfig.common.enumer;

import com.lewis.bohconfig.common.domain.SwitchConstant;

/**
 * Created by zhangminghua on 2017/1/13.
 */
public enum SwitchEnum {
    INTERFACE_LEVEL(1, SwitchConstant.INTERFACE_LEVEL_NAME_PRE),
    BUSSINESS_LEVEL(2, SwitchConstant.BUSSINESS_LEVEL_NAME_PRE),
    FUNCTION_LEVEL(3, SwitchConstant.FUNCTION_LEVEL_NAME_PRE),
    PARAM_LEVAL(4, SwitchConstant.PARAM_LEVAL_NAME_PRE),
    LOGGER_LEVEL(5, SwitchConstant.LOGGER_LEVEL_NAME_PRE),
    VARIABLE_LEVEL(6, SwitchConstant.VARIABLE_LEVEL);

    private Integer code;

    private String namePre;

    SwitchEnum(Integer code, String namePre) {
        this.code = code;
        this.namePre = namePre;
    }

    public static SwitchEnum of(Integer code) {
        return SwitchConstant.switchCode2EnumMap.get(code);
    }

    public static SwitchEnum of(String namePre) {
        return SwitchConstant.switchNamePre2EnumMap.get(namePre);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNamePre() {
        return namePre;
    }

    public void setNamePre(String namePre) {
        this.namePre = namePre;
    }

    @Override
    public String toString() {
        return "SwitchEnum{" +
                "code=" + code +
                ", namePre='" + namePre + '\'' +
                '}';
    }
}
