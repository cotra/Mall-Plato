package com.linya.admin.bo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthBo {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 对密码进行加密
     * @param password
     * @return
     */
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
    /**
     * 对原密码和已加密的密码进行匹配，判断是否相等
     * @param password
     * @param encodedPassword
     * @return
     */
    public boolean match(String password, String encodedPassword) {
        boolean result = passwordEncoder.matches(password, encodedPassword);
        return result;
    }
}
