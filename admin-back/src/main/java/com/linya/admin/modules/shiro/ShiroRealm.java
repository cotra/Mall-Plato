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
     * principals：身份 / credentials：证明
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String guestName = (String)token.getPrincipal();  //访客用户名
        List<UmsAdminAuth> list = service.getAdmin(guestName);// 无记录
        if(list.size() == 0 || list.size() != 1) {
            throw new UnknownAccountException("账户不存在");
        }
        UmsAdminAuth adminAuth = list.get(0);

        // 对照密码
        String ControlPwd = adminAuth.getPassword();

        return new SimpleAuthenticationInfo(guestName, ControlPwd, getName());
    }
}