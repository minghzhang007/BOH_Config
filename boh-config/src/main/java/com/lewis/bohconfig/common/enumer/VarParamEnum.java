package com.lewis.bohconfig.common.enumer;

/**
 * Created by zhangminghua on 2017/1/7.
 */
public enum VarParamEnum {
    ;

    private String identity;

    private String description;

    private String content;

    VarParamEnum(String identity, String description, String content) {
        this.identity = identity;
        this.description = description;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "VarParamEnum{" +
                "identity='" + identity + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
