package com.linya.admin.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("AppUserDetailsService" + " | " + s);
        AppUserDetails details = new AppUserDetails("3", "{noop}" + "3");

//        throw new UsernameNotFoundException("用户名不存在");
//        throw new LockedException("用户被锁定");
        return details;
    }
}