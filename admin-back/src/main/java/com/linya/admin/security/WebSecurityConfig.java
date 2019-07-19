package com.linya.admin.security;

import com.linya.admin.security.Point.AppAuthenticationEntryPoint;
import com.linya.admin.security.filter.TokenAuthenticationFilter;
import com.linya.admin.security.handler.AppAccessDeniedHandler;
import com.linya.admin.security.service.AppUserDetailsService;
import com.linya.admin.ums.UmsApiUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    AppUserDetailsService appUserDetailsService;

    @Bean
    TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    @Bean
    AppAccessDeniedHandler appAccessDeniedHandler() {
        return new AppAccessDeniedHandler();
    }

    @Bean
    AppAuthenticationEntryPoint appAuthenticationEntryPoint() {
        return new AppAuthenticationEntryPoint();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(appUserDetailsService);
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不使用csrf/表单登录
        HttpSecurity security = http.csrf().disable().formLogin().disable().logout().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().headers().cacheControl().disable().and();
        // filter
        HttpSecurity custom = security.addFilterAt(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        // 自定义
        HttpSecurity role = custom.exceptionHandling().authenticationEntryPoint(appAuthenticationEntryPoint()).accessDeniedHandler(appAccessDeniedHandler()).and();
        // 规则
        role.authorizeRequests().antMatchers(UmsApiUrl.AUTH + "/**").permitAll().anyRequest().authenticated().and();
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
