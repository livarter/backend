package com.livarter.app.controller;

import com.livarter.app.dto.BadgeMemberListDto;
import com.livarter.app.service.BadgeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 황수영
 * @fileName : BadgeController
 * @since : 2024-01-24
 * 내용 : 뱃지 기능용 컨트롤러
 */

@Log4j
@RequestMapping("/api/v1/member/badge")
@RestController
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping
    public ResponseEntity<BadgeMemberListDto> getBadges(Authentication authentication) {
        log.debug("회원 뱃지 정보 조회 : " + authentication.getName());
        BadgeMemberListDto badgeListDto = badgeService.getBadgesByMember(authentication.getName());
        return new ResponseEntity<>(badgeListDto, HttpStatus.ACCEPTED);
    }
}