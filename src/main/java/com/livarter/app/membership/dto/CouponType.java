package com.livarter.app.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : 황수영
 * @fileName : Coupon
 * @since : 2024-01-27
 */

@Getter
@AllArgsConstructor
public enum CouponType {

    BIRTHDAY(100),
    FIRST_REVIEW(101);

    private int id;
}
