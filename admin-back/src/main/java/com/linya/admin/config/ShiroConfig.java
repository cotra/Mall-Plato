package com.linya.admin.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        System.out.println("realm");
        TextConfigurationRealm realm = new TextConfigurationRealm();
        //添加两个用户
        //joe.coder=password 角色 user
        //jill.coder=password 角色 admin
        realm.setUserDefinitions("joe.coder=password,user\n" +
                "jill.coder=password,admin");

        //设置角色admin的权限是read,write
        //设置角色user的权限是read
        realm.setRoleDefinitions("admin=read,write\n" +
                "user=read");
        realm.setCachingEnabled(true);

        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        System.out.println("shiroFilterChainDefinition");
        chainDefinition.addPathDefinition("/api/**", "authc, roles[admin]");
        return chainDefinition;
    }
}
