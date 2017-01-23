package com.lewis.bohconfig.domain;

import java.util.List;

/**
 * Created by zhangminghua on 2017/1/22.
 */
public class BohSwitchDOWithHost extends BohSwitchDO {

    private List<String> hosts;

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public BohSwitchDOWithHost() {
    }
}
