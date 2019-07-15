package com.linya.admin.modules.security.service;

import com.linya.admin.modules.security.model.AppUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AppUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) {
        System.out.println("AppUserDetailsService");
        AppUserDetails details = new AppUserDetails("admin", "{noop}" + "123456");
        return details;
    }
}