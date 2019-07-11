package com.linya.admin.bo;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Auth {

    public static String passwordToMd5Hash(String password, String salt) {
        String md5 = new Md5Hash(password, salt).toString();
        return md5;
    }
}
