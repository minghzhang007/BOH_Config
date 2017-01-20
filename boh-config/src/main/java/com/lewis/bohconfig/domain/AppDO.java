package com.lewis.bohconfig.domain;

import java.util.List;

/**
 * Created by zhangminghua on 2017/1/19.
 */
public class AppDO {

    private Integer systemId;
    private List<String> identities;
    public AppDO(Integer systemId, List<String> identities) {
        this.systemId = systemId;
        this.identities = identities;
    }
    public AppDO(Integer systemId) {
        this.systemId = systemId;
    }

    public AppDO() {
    }

    public List<String> getIdentities() {
        return identities;
    }

    public void setIdentities(List<String> identities) {
        this.identities = identities;
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
                ", identities=" + identities +
                '}';
    }
}
