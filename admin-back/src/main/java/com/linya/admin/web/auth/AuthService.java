package com.linya.admin.web.auth;

import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Sender;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    /**
     * 登录业务
     */
    public Cstp<String> signIn() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("user123", "1234526"));
            return Sender.ok();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return Sender.fail();
        }

    }
}
