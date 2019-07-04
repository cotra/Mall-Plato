package com.linya.admin.modules.shiro;

import com.linya.admin.dto.UmsAdminAuth;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    ShiroRealmService service;

    /**
     * 重写realm名称
     */
    @Override
    public String getName() {
        return "appShiroRealm";
    }

    /**
     * 支持类型,现在支持UsernamePasswordToken类型的Token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        System.out.println("Authorization");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String guestName = (String)token.getPrincipal();  //得到用户名
        String guestPwd = new String((char[])token.getCredentials()); //得到密码
        List<UmsAdminAuth> list = service.getAdmin(guestName);
        if(list.size() == 0) {
            throw new UnknownAccountException("账户或密码错误");
        }

        return new SimpleAuthenticationInfo(guestName, "123", getName());
    }
}