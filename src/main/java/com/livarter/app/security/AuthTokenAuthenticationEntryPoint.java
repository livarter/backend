package com.livarter.app.security;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 황수영
 * @fileName : AuthTokenAuthenticationEntryPoint
 * @since : 2024-01-19
 * 내용 : 인증되지 않은 사용자의 요청 처리 핸들러
 */
@Log4j
@Component
public class AuthTokenAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        log.debug("AuthTokenAuthenticationEntryPoint : 인증되지 않은 사용자의 요청");

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}