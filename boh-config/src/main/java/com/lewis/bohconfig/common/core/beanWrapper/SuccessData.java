package com.lewis.bohconfig.common.core.beanWrapper;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class SuccessData implements ResponseData {
    private boolean success = true;

    private Object data;

    public SuccessData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
