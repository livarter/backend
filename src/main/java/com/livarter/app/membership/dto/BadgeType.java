package com.livarter.app.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : 황수영
 * @fileName : BadgeType
 * @since : 2024-01-27
 * 내용 : 뱃지 타입용
 */
@Getter
@AllArgsConstructor
public enum BadgeType {

    FIRST_REVIEW(1),
    COMMENTER(2),
    PERSPECTIVE(3),
    BRAND_FANATIC(4),
    HIGH_ATTENDANCE(5),
    NICE_INSIGHT(6),
    FIRST_PURCHASE(7),
    HEAVY_SHOPPER(8),
    COUPON_MANIAC(9);

    private int id;
}
