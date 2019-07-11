package com.linya.admin.modules.cstp;

import java.io.Serializable;

public class Cstp<T> implements Serializable {
    private boolean ok;
    private T data;
    private String flag;

    public Cstp(boolean ok, T data, String flag) {
        this.ok = ok;
        this.data = data;
        this.flag = flag;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
