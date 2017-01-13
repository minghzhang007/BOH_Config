package com.lewis.bohconfig.common.domain;

/**
 * Created by zhangminghua on 2017/1/13.
 */
public class ZKNode {

    private String path;

    private String data;

    private Integer version;

    private String identity;

    public ZKNode() {}

    public ZKNode(String path) {
        this.path = path;
    }

    public ZKNode(String path, String data) {
        this.path = path;
        this.data = data;
    }

    public ZKNode(String path, String data, String identity) {
        this.path = path;
        this.data = data;
        this.identity = identity;
    }

    public ZKNode(String path, String data, Integer version) {
        this.path = path;
        this.data = data;
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
