package com.linya.admin.config;

import com.linya.admin.modules.shiro.ShiroRealm;
import com.linya.admin.ums.UmsApiUrl;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    /**
     * 授权控制配置
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        // 需认证
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition(UmsApiUrl.ROLE + "/**", "authc,roles[PRODUCT_MANAGER]");
        return definition;
    }

    // 实现的realm
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    @Bean
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    // 授权管理器
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm());
        return manager;
    }
}
