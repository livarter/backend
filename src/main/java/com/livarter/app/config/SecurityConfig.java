package com.livarter.app.config;

import com.livarter.app.security.AuthTokenAccessDeniedHandler;
import com.livarter.app.security.AuthTokenAuthenticationEntryPoint;
import com.livarter.app.security.AuthTokenFilterConfigurer;
import com.livarter.app.security.AuthTokenGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : 황수영
 * @fileName : SecurityConfig
 * @since : 2024-01-19
 */
@Log4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthTokenGenerator authTokenGenerator;
    private final AuthTokenAccessDeniedHandler authTokenAccessDeniedHandler;
    private final AuthTokenAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/**", "/", "/api/v1/auth/**", "/api/v1/products/**", "/api/v1/purchase/**");
    }
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                    .csrf().disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .headers()
                    .httpStrictTransportSecurity().disable()
                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                    .exceptionHandling()
                    .accessDeniedHandler(authTokenAccessDeniedHandler)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/v1/auth/**").permitAll()
                    .antMatchers("/api/v1/member/**").authenticated()
                    .antMatchers("/api/v1/products/**").permitAll()
                    .antMatchers("/api/v1/purchase/**").permitAll()
                    .antMatchers("/api/v1/reply/**").permitAll()
                //.antMatchers("/api/v1/member/**").hasRole("MEMBER") // 이후에 멤버만 허용
                    .anyRequest().permitAll()
                .and()
                    .apply(new AuthTokenFilterConfigurer(authTokenGenerator));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}