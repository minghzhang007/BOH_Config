package com.lewis.bohconfig.common.domain;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class ResponseVo {
    private boolean isSuccess;

    private String msg;

    private int resultCode;

    private Object data;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseVo() {
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "isSuccess=" + isSuccess +
                ", msg='" + msg + '\'' +
                ", resultCode=" + resultCode +
                ", data=" + data +
                '}';
    }
}
