package com.linya.admin.modules.api;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/23.
 */

public class Api<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public Api() {
    }

    public Api(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
