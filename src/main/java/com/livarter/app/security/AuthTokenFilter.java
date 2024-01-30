package com.livarter.app.security;

import com.livarter.app.domain.enumType.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 황수영
 * @fileName : AuthTokenFilter
 * @since : 2024-01-19
 * 내용 : 토큰 검증 후 시큐리티 컨텍스트에 저장하는 필터
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

    private final AuthTokenGenerator authTokenGenerator;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            log.debug("AuthTokenFilter : request" + request);
            String accessToken = resolveToken(request);
            log.debug("AuthTokenFilter : accessToken" + accessToken);
            authTokenGenerator.isTokenValidate(accessToken);
            Authentication authentication = authTokenGenerator.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            log.debug("AuthTokenFilter : accessToken 토큰이 유효하지 않습니다.");
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(Header.AUTH.getValue());
        if (bearerToken != null && bearerToken.startsWith(Header.BEARER.getValue())) {
            return bearerToken.substring(Header.BEARER.getValue().length());
        }
        return null;
    }
}