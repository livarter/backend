package com.livarter.app.controller;

import com.livarter.app.dto.CouponListResDto;
import com.livarter.app.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @author : 황수영
 * @fileName : CouponController
 * @since : 2024-
 * 01-24
 */
@Log4j
@RequestMapping("/api/v1/member/coupon")
@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping
    public ResponseEntity<CouponListResDto> getCoupons(Authentication authentication) {
        log.debug("쿠폰 전체 조회 , 회원 아이디: " + authentication.getName());
        CouponListResDto couponListResDto = couponService.getCouponsByMemberId(authentication.getName());
        log.debug("쿠폰 전체 조회 : " + couponListResDto);
        return new ResponseEntity<>(couponListResDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{couponId}")
    public ResponseEntity<Void> removeCoupon(@PathVariable int couponId, Authentication authentication) {
        log.debug("쿠폰 사용하기 쿠폰 아이디 : " + couponId +" 회원 아이디: " + authentication.getName());
        couponService.removeCoupon(couponId, authentication.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}