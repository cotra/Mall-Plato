package com.linya.admin.bo;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;

public class TokenBoTest {

    @Test
    public void test() {
        byte[] key = SecureUtil.generateKey("AES").getEncoded();
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        System.out.println(new String(key));
        //加密
        byte[] encrypt = aes.encrypt("test");
//解密
        byte[] decrypt = aes.decrypt(encrypt);
        System.out.println(new String(decrypt));
    }
}