package com.linya.admin.modules.shiro;

import com.linya.admin.dto.UmsAdminAuth;
import com.linya.admin.modules.cstp.Cstp;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

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
     * principals：身份 / credentials：证明
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String guestName = (String)token.getPrincipal();  //访客用户名
        Cstp<UmsAdminAuth> cstp = service.getAdmin(guestName); // 根据访客用户名查找用户
        if(!cstp.isOk()) {
            throw new UnknownAccountException();
        }
        UmsAdminAuth ControlAdmin = cstp.getData();
        if(ControlAdmin.getStatus() == 0) {
            throw new LockedAccountException();
        }

        // 返回对照用户名和对照MD5
        return new SimpleAuthenticationInfo(ControlAdmin.getUsername(), ControlAdmin.getPassword(), getName());
    }
}