package com.lewis.bohconfig.domain;

/**
 * Created by zhangminghua on 2017/1/19.
 */
public class AppDO {

    private Integer systemId;

    public AppDO(Integer systemId) {
        this.systemId = systemId;
    }

    public AppDO() {
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "AppDO{" +
                "systemId=" + systemId +
                '}';
    }
}
