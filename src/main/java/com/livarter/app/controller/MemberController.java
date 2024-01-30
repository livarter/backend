package com.livarter.app.controller;

import com.livarter.app.domain.Catalog;
import com.livarter.app.dto.CatalogListResDto;
import com.livarter.app.dto.MemberGradeDto;
import com.livarter.app.dto.MemberResDto;
import com.livarter.app.dto.MemberUpdateReqDto;
import com.livarter.app.service.BadgeService;
import com.livarter.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : MemberController
 * @since : 2024-01-21
 * 내용 : 회원 정보 조회/수정용 컨트롤러
 */

@Log4j
@RequestMapping("/api/v1/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final BadgeService badgeService;

    @GetMapping
    public ResponseEntity<MemberResDto> getMember(Authentication authentication) {
        log.debug("회원 정보 조회 : " + authentication.getName());
        MemberResDto memberResDto = memberService.getMember(authentication.getName());
        return new ResponseEntity<>(memberResDto, HttpStatus.ACCEPTED);
    }

    @PatchMapping
    public ResponseEntity<MemberResDto> updateMember(
            @RequestBody MemberUpdateReqDto memberUpdateReqDto,
            Authentication authentication) {
        log.debug("회원 정보 수정 : " + authentication.getName());
        MemberResDto memberResDto = memberService.updateMember(authentication.getName(), memberUpdateReqDto);
        return new ResponseEntity<>(memberResDto, HttpStatus.ACCEPTED);
    }

    @PostMapping("/badge/{badgeId}")
    public ResponseEntity<Void> earnedBadge(@PathVariable("badgeId") int badgeId,
                                                    Authentication authentication) {
        log.debug("뱃지 부여하기 : " + authentication.getName());
        badgeService.earedBadge(badgeId, authentication.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping ("/grade")
    public ResponseEntity<MemberGradeDto> getMembership(Authentication authentication) {
        log.debug("멤버십 조회하기 : " + authentication.getName());
        MemberGradeDto memberGradeDto = memberService.getMemberGradeInfo(authentication.getName());
        log.debug("멤버십 조회하기 memberGradeDto : " + memberGradeDto);
        return new ResponseEntity<>(memberGradeDto, HttpStatus.ACCEPTED);
    }

    // 포인트 적립
    @PatchMapping("/point")
    public ResponseEntity<Integer> increasePoint(@RequestParam("money") int money,
                                              Authentication authentication) {
        log.debug("포인트 적립 : 회원 아이디" + authentication.getName());
        log.debug("포인트 적립 : 회원 ROLE" + authentication.getAuthorities());
        // 원래 가격이랑 ROLE에 따라서 포인트 적립
        int point = memberService.increasePoint(money, authentication.getName());
        return new ResponseEntity<>(point, HttpStatus.ACCEPTED);
    }

    // 포인트 사용
    @DeleteMapping("/point")
    public ResponseEntity<Void> decreasePoint(@RequestParam("point") int point,
                                              Authentication authentication) {
        log.debug("포인트 차감 : " + authentication.getName());
        memberService.decreasePoint(point, authentication.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // 나의 방 카탈로그 조회
    @GetMapping("/catalogs")
    public ResponseEntity<CatalogListResDto> getCatalogs(Authentication authentication) {
        log.debug("getCatalogs ");
        List<Catalog> catalogs =  memberService.getCatalogs(authentication.getName());
        CatalogListResDto catalogListResDto = new CatalogListResDto(catalogs);
        return new ResponseEntity<>(catalogListResDto, HttpStatus.ACCEPTED);
    }
}