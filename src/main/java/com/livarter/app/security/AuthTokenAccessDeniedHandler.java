package com.livarter.app.security;

import lombok.extern.log4j.Log4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 황수영
 * @fileName : AuthTokenAccessDeniedHandler
 * @since : 2024-01-19
 * 내용 : 인가되지 않은 사용자의 요청 처리 핸들러
 */
@Log4j
@Component
public class AuthTokenAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        log.debug("AuthTokenAccessDeniedHandler : 인가되지 않은 사용자의 요청");

        response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
    }
}