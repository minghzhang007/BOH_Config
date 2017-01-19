package com.lewis.bohconfig.common.enumer;

/**
 * Created by zhangminghua on 2017/1/19.
 */
public enum OperationEnum {
    CREATE(1),UPDATE(2),DELETE(3),QUERY(4);

    private int code;

    OperationEnum(int code) {
        this.code = code;
    }
}
