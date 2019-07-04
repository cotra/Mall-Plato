package com.linya.admin.modules.cstp;

public class Sender {

    // 生成方法
    public static final <T> Cstp<T> create(boolean ok, T data, Integer flag) {
        Cstp<T> result = new Cstp<>(ok, data, flag);
        return result;
    }

    // 成功返回,无数据
    public static final <T> Cstp<T> ok() {
        Cstp<T> result = create(true, null, null);
        return result;
    }

    // 成功返回,有数据
    public static final <T> Cstp<T> ok(T data) {
        Cstp<T> result = create(true, data, null);
        return result;
    }

    // 失败返回,无标识
    public static final <T> Cstp<T> fail() {
        Cstp<T> result = create(false, null, null);
        return result;
    }

    // 失败返回,有标识
    public static final <T> Cstp<T> fail(Integer flag) {
        Cstp<T> result = create(false, null, flag);
        return result;
    }
}
