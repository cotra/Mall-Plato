package com.linya.admin.web.api;

/**
 * Created by Administrator on 2018/3/23.
 */
public class Result {

    // 生成方法
    public static final <T> Api<T> create(String code, String msg, T data) {
        Api<T> api = new Api<>();
        api.setCode(code);
        api.setMsg(msg);
        api.setData(data);
        return api;
    }

    // 成功返回,无数据
    public static final <T> Api<T> ok() {
        String code = Code.SUCCESS.getCode();
        String msg = Code.SUCCESS.getMsg();
        Api<T> Api = create(code, msg, null);
        return Api;
    }

    // 成功返回,有数据
    public static final <T> Api<T> ok(T data) {
        String code = Code.SUCCESS.getCode();
        String msg = Code.SUCCESS.getMsg();
        Api<T> Api = create(code, msg, data);
        return Api;
    }

    // 失败返回,无数据
    public static final <T> Api<T> fail() {
        String code = Code.FAILURE.getCode();
        String msg = Code.FAILURE.getMsg();
        Api<T> Api = create(code, msg, null);
        return Api;
    }

    // 失败返回,有数据
    public static final <T> Api<T> fail(T data) {
        String code = Code.FAILURE.getCode();
        String msg = Code.FAILURE.getMsg();
        Api<T> Api = create(code, msg, data);
        return Api;
    }
}
