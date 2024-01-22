package com.livarter.app.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
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
@RequiredArgsConstructor
public class AuthTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final AuthTokenGenerator authTokenGenerator;

    @Override
    public void configure(HttpSecurity httpSecurity) {
        AuthTokenFilter customFilter = new AuthTokenFilter(authTokenGenerator);
        httpSecurity.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}