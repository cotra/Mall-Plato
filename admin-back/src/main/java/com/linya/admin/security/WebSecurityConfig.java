package com.linya.admin.security;

import com.linya.admin.security.filter.AppAuthenticationFilter;
import com.linya.admin.security.service.AppUserDetailsService;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    public UserDetailsService customUserDetailsService() {
        return new AppUserDetailsService();
    }

//    @Bean
//    AppOncePerRequestFilter appOncePerRequestFilter() {
//        return new AppOncePerRequestFilter();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(customUserDetailsService());
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不使用csrf/表单登录
        HttpSecurity security = http.csrf().disable().formLogin().disable();
        // 规则
        HttpSecurity and = security.authorizeRequests().antMatchers(UmsApiUrl.ROLE + "/*").authenticated().and();
        // filter
        and.addFilterAt(new AppAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        // 自定义返回
//        set.exceptionHandling().authenticationEntryPoint(new AppAuthenticationEntryPoint()).accessDeniedHandler(new AppAccessDeniedHandler()).and();
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
}
