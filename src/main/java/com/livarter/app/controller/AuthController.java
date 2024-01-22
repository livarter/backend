package com.livarter.app.controller;

import com.livarter.app.security.dto.LoginReqDto;
import com.livarter.app.security.dto.LoginResDto;
import com.livarter.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 황수영
 * @fileName : AuthController
 * @since : 2024-01-19
 */
@Log4j
@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResDto> testLogin(@RequestBody LoginReqDto loginReqDto) {
        LoginResDto loginResDto = memberService.login(loginReqDto);
        log.debug("이메일로 회원가입 - 로그인 토큰 : " + loginReqDto.getLoginToken());
        log.debug("tokenDto : " + loginResDto.getAccessToken());
        return new ResponseEntity<>(loginResDto, HttpStatus.ACCEPTED);
    }
}