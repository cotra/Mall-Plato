package com.linya.admin.api;

/**
 * Created by Administrator on 2018/3/23.
 */
public enum Code {
    // 成功
    SUCCESS("0000", "操作成功"),
    // 失败
    FAILURE("1000", "操作失败");

    private final String code;
    private final String msg;

    private Code(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
