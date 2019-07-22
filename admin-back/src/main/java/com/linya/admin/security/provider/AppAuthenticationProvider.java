package com.linya.admin.security.provider;

import com.linya.admin.security.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    AppUserDetailsService appUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = (String) authentication.getPrincipal();
        UserDetails userDetails = appUserDetailsService.loadUserByUsername(id);
//        System.out.println(authentication.getCredentials());
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
