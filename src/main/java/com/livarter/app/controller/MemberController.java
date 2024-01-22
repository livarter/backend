package com.livarter.app.controller;

import com.livarter.app.dto.MemberResDto;
import com.livarter.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @author : 황수영
 * @fileName : MemberController
 * @since : 2024-01-21
 */

@Log4j
@RequestMapping("/api/v1/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<MemberResDto> getMember(Authentication authentication) {
        log.debug("회원 정보 조회 : " + authentication.getName());
        MemberResDto memberResDto = memberService.getMember(authentication.getName());
        return new ResponseEntity<>(memberResDto, HttpStatus.ACCEPTED);
    }
}