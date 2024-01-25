package com.livarter.app.service;

import com.livarter.app.dto.CouponListResDto;

/**
 * @author : 황수영
 * @fileName : CouponService
 * @since : 2024-01-24
 */
public interface CouponService {

    CouponListResDto getCouponsByMemberId(String memberId);

    void removeCoupon(int couponId, String memberId);
}