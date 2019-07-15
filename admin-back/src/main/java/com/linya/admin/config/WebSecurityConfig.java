package com.linya.admin.config;

import com.linya.admin.modules.security.Point.AppAuthenticationEntryPoint;
import com.linya.admin.modules.security.handler.AppAccessDeniedHandler;
import com.linya.admin.modules.security.service.AppUserDetailsService;
import com.linya.admin.ums.UmsApiUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    UserDetailsService customUserDetailsService() {
        return new AppUserDetailsService();
    }

//    @Bean
//    AppOncePerRequestFilter appOncePerRequestFilter() {
//        return new AppOncePerRequestFilter();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) {
        try {
            builder.userDetailsService(customUserDetailsService());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不使用csrf
        HttpSecurity security = http.csrf().disable();
        // 规则
        HttpSecurity set = security.authorizeRequests().antMatchers(UmsApiUrl.ROLE + "/*").authenticated().and();
        // 自定义返回
        set.exceptionHandling().authenticationEntryPoint(new AppAuthenticationEntryPoint()).accessDeniedHandler(new AppAccessDeniedHandler()).and();
    }

    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**");
    }
}
