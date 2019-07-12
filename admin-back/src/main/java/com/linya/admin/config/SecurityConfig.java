package com.linya.admin.config;

import com.linya.admin.modules.security.Point.AppAuthenticationEntryPoint;
import com.linya.admin.modules.security.handler.AppAccessDeniedHandler;
import com.linya.admin.modules.security.service.AppUserDetailsService;
import com.linya.admin.ums.UmsApiUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new AppUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**");
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁止csrf
        HttpSecurity security = http.exceptionHandling().accessDeniedHandler(new AppAccessDeniedHandler()).authenticationEntryPoint(new AppAuthenticationEntryPoint()).and();
        // 自定义异常处理
        // 规则
        security.authorizeRequests().antMatchers(UmsApiUrl.ROLE + "/*").authenticated();
    }
}
