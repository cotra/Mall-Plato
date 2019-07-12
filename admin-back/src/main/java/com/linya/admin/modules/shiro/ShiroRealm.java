package com.linya.admin.modules.shiro;

import com.linya.admin.dto.UmsAdminAuth;
import com.linya.admin.modules.cstp.Cstp;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    public static Logger LOG = LoggerFactory.getLogger(ShiroRealm.class);

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
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        LOG.info("授权访问验证");
        UmsAdminAuth user = (UmsAdminAuth) getAvailablePrincipal(principal);
        Cstp<Set<String>> roles = service.getAdminRoles(user.getId());
        Cstp<Set<String>> perms = service.getAdminPerms(user.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(roles.isOk()) {
            info.setRoles(roles.getData());
        }
        if(perms.isOk()) {
            info.setStringPermissions(perms.getData());
        }

        return info;
    }

    /**
     * 认证
     * principal：身份 / credentials：证明
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String guestName = upToken.getUsername(); //访客用户名
        if(guestName == null) {
            throw new UnknownAccountException(); // 访客名为null
        }
        Cstp<UmsAdminAuth> cstp = service.getAdmin(guestName); // 根据访客用户名查找用户
        if(!cstp.isOk()) {
            throw new UnknownAccountException(); // 账户错误
        }
        UmsAdminAuth ControlAdmin = cstp.getData();
        if(ControlAdmin.getStatus() == 0) {
            throw new LockedAccountException(); // 账户被锁定
        }

        // 返回对照用户名和对照MD5
        return new SimpleAuthenticationInfo(ControlAdmin, ControlAdmin.getPassword(), getName());
    }
}