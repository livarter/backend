package com.livarter.app.security;

import com.livarter.app.domain.enumType.Header;
import com.livarter.app.security.dto.KakaoResDto;
import com.livarter.app.security.dto.LoginReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author : 황수영
 * @fileName : KakaoOauthClient
 * @since : 2024-01-20
 */
@Log4j
@Service
@RequiredArgsConstructor
public class KakaoOauthClient {

    @Value("${oauth.kakao.request-uri}")
    private String reqUri;
    private final RestTemplate restTemplate = new RestTemplate();

    public String getEmail(LoginReqDto loginRequestDto) {
        KakaoResDto kakaoResDto = getUserInfoByLoginToken(loginRequestDto.getLoginToken());
        return kakaoResDto.getEmail();
    }

    private KakaoResDto getUserInfoByLoginToken(String accessToken) {
        log.info("getUserInfoByLoginToken() - accessToken : " + accessToken);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set(Header.AUTH.getValue(), Header.BEARER.getValue() + accessToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        return getOAuthInfo(request);
    }

    private KakaoResDto getOAuthInfo(HttpEntity<MultiValueMap<String, String>> request) {
        KakaoResDto kakaoResDto = null;
        try {
            kakaoResDto = restTemplate.postForObject(reqUri, request, KakaoResDto.class);
            log.debug("kakaoResDto : " + kakaoResDto);
        } catch(HttpClientErrorException e) {
            log.error("HttpClientErrorException : " + e.getResponseBodyAsString());
        } catch(HttpServerErrorException e) {
            log.error("HttpServerErrorException : " + e.getResponseBodyAsString());
        } catch(Exception e) {
            log.error("Exception : " + e);
        }
        return kakaoResDto;
    }
}