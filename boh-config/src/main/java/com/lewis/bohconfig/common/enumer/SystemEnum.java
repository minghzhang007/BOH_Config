package com.lewis.bohconfig.common.enumer;

import com.lewis.bohconfig.common.domain.SwitchConstant;

/**
 * Created by zhangminghua on 2017/1/13.
 */
public enum SystemEnum {
    BOH_NM(1, SwitchConstant.SYSTEM_BOH_NM),
    BOH_PRC(2,SwitchConstant.SYSTEM_BOH_PRC),
    BOH_OTH(3,SwitchConstant.SYSTEM_BOH_OTH),
    BOH_CACHE(4,SwitchConstant.SYSTEM_BOH_CACHE),
    BOH_CNF(5,SwitchConstant.SYSTEM_BOH_CNF);

    SystemEnum(Integer code, String systemName) {
        this.code = code;
        this.systemName = systemName;
    }

    public static SystemEnum of(Integer code){
        switch (code){
            case 1:
                return SystemEnum.BOH_NM;
            case 2:
                return SystemEnum.BOH_PRC;
            case 3:
                return SystemEnum.BOH_OTH;
            case 4:
                return SystemEnum.BOH_CACHE;
            case 5:
                return SystemEnum.BOH_CNF;
            default:
                return SystemEnum.BOH_NM;
        }
    }

    private Integer code;

    private String systemName;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
