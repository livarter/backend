package com.livarter.app.domain.enumType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : 황수영
 * @fileName : MembershipLevel
 * @since : 2024-01-20
 * 내용 : 멤버십 등급관련 enum 타입
 */

@Getter
@AllArgsConstructor
public enum Grade {
    BEGINNER( 1, 0),
    ARTIEST(2, 30_000),
    LIVARTIEST(3, 100_000);

    private final int savingRate;   // 포인트 적립 비율
    private final int minPoint;     // 해당 등급으로 올라가는 최저 포인트

    // 적립 포인트
    public int getPointOfMoneyByGrade(int money) {
        int point = (int) (money * (0.01 * savingRate));
        return point;
    }
}