package com.linya.admin.security.service;

import com.linya.admin.security.model.AppUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("AppUserDetailsService");
        AppUserDetails details = new AppUserDetails("admin", "{noop}" + "123456");
        return details;
    }
}