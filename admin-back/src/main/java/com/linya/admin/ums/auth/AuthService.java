package com.linya.admin.ums.auth;

import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    /**
     * 登录
     */
    public Cstp<String> login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();

        String base64Encoded = new Md5Hash(password, "123").toString();
        System.out.println(base64Encoded);
        // 密码处理
        try {
            subject.login(new UsernamePasswordToken(username, password));
            return Result.ok();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 注销
     */
    public Cstp<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return Result.ok();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }
}
