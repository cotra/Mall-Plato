package com.linya.admin.web.auth;

import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Sender;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    /**
     * 登录
     */
    public Cstp<String> login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();

        String base64Encoded = Base64.encodeToString(username.getBytes());
        System.out.println(base64Encoded);
        // 密码处理
        try {
            subject.login(new UsernamePasswordToken(username, password));
            return Sender.ok();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Sender.fail();
        }
    }

    /**
     * 注销
     */
    public Cstp<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return Sender.ok();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Sender.fail();
        }
    }
}
