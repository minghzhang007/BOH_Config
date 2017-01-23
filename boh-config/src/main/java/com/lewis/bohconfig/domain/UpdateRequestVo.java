package com.lewis.bohconfig.domain;

import com.lewis.bohconfig.common.util.JsonUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/23.
 */
public class UpdateRequestVo {
    private String identity;

    private List<String> hosts;

    public UpdateRequestVo(String identity, List<String> hosts) {
        this.identity = identity;
        this.hosts = hosts;
    }

    public UpdateRequestVo(String identity) {
        this.identity = identity;
    }

    public UpdateRequestVo() {
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    @Override
    public String toString() {
        return "UpdateRequestVo{" +
                "identity='" + identity + '\'' +
                ", hosts=" + hosts +
                '}';
    }

    public static void main(String[] args) {
        UpdateRequestVo requestVo = new UpdateRequestVo();
        requestVo.setHosts(Arrays.asList("172.30.123.94:12501","172.30.123.94:12502"));
        requestVo.setIdentity("vari_resCostQuerySize");
        System.out.println(JsonUtil.toString(requestVo));
    }
}
