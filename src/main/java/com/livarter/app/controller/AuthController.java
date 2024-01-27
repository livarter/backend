package com.livarter.app.controller;

import com.livarter.app.security.AuthTokenGenerator;
import com.livarter.app.security.dto.LoginReqDto;
import com.livarter.app.security.dto.LoginResDto;
import com.livarter.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final AuthTokenGenerator authTokenGenerator;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResDto> testLogin(@RequestBody LoginReqDto loginReqDto) {
        LoginResDto loginResDto = memberService.login(loginReqDto);
        log.debug("이메일로 회원가입 - 로그인 토큰 : " + loginReqDto.getLoginToken());
        log.debug("tokenDto : " + loginResDto.getAccessToken());
        return new ResponseEntity<>(loginResDto, HttpStatus.ACCEPTED);
    }

    // 테스트용 로그인 토큰
    @GetMapping(value = "/test")
    public ResponseEntity<String> createTestToken(@RequestParam String memberId, @RequestParam int validity) {
        String token = "Bearer " + authTokenGenerator.createJwtToken(memberId, validity);
        log.debug("테스트 회원가입 - 로그인 토큰 : " + token);
        return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
    }
}