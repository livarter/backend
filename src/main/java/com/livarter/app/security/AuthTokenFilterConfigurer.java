package com.livarter.app.security;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author : 황수영
 * @fileName : AuthTokenFilterConfigurer
 * @since : 2024-01-19
 */
@Log4j
@Component
public class AuthTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthTokenGenerator authTokenGenerator;

    public AuthTokenFilterConfigurer(AuthTokenGenerator authTokenGenerator) {
        this.authTokenGenerator = authTokenGenerator;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) {
        AuthTokenFilter customFilter = new AuthTokenFilter(authTokenGenerator);
        httpSecurity.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}