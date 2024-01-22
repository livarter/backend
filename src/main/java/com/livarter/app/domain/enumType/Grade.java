package com.livarter.app.domain.enumType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : 황수영
 * @fileName : MembershipLevel
 * @since : 2024-01-20
 */

@Getter
@AllArgsConstructor
public enum Grade {
    BEGINNER(1, 1, 0),
    ARTIEST(3, 3, 30_000),
    LIVARTIEST(5, 5, 100_000);

    private final int discountRate; // 할인 비율
    private final int savingRate;   // 포인트 적립 비율
    private final int minPoint;     // 해당 등급으로 올라가는 최저 포인트
}