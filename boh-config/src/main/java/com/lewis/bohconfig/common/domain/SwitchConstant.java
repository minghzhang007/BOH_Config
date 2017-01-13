package com.lewis.bohconfig.common.domain;

import com.lewis.bohconfig.common.enumer.SwitchEnum;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangminghua on 2017/1/13.
 */
public class SwitchConstant {

    public static final String INTERFACE_LEVEL_NAME_PRE = "inte_";

    public static final String BUSSINESS_LEVEL_NAME_PRE = "busi_";

    public static final String FUNCTION_LEVEL_NAME_PRE = "func_";

    public static final String PARAM_LEVAL_NAME_PRE = "para_";

    public static final String LOGGER_LEVEL_NAME_PRE = "logg_";

    public static final String VARIABLE_LEVEL = "vari_";

    public static final String SYSTEM_BOH_NM ="BOH-NM";

    public static final String SYSTEM_BOH_PRC ="BOH-PRC";

    public static final String SYSTEM_BOH_OTH ="BOH-OTH";

    public static final String SYSTEM_BOH_CACHE ="BOH-CACHE";

    public static final String SYSTEM_BOH_CNF ="BOH-CNF";

    public static final Map<Integer,String> switchCode2NamePreMap = new HashMap<Integer,String>();
    public static final Map<Integer,SwitchEnum> switchCode2EnumMap = new HashMap<Integer,SwitchEnum>();
    public static final Map<String,Integer> switchNamePre2CodeMap = new HashMap<String,Integer>();
    public static final Map<String,SwitchEnum> switchNamePre2EnumMap = new HashMap<String,SwitchEnum>();

    static {
        SwitchEnum[] values = SwitchEnum.values();
        if (ArrayUtils.isNotEmpty(values)) {
            for (SwitchEnum value : values) {
                switchCode2NamePreMap.put(value.getCode(),value.getNamePre());
                switchNamePre2CodeMap.put(value.getNamePre(),value.getCode());
                switchCode2EnumMap.put(value.getCode(),value);
                switchNamePre2EnumMap.put(value.getNamePre(),value);
            }
        }
    }

}
