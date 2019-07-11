package com.linya.admin.bo;

import org.apache.shiro.crypto.hash.Md5Hash;

public class AuthBo {

    public static String passwordToMd5Hash(String password) {
        String md5 = new Md5Hash(password).toString();
        return md5;
    }
}
