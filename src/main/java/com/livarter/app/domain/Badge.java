package com.livarter.app.domain;

import lombok.*;

/**
 * @author : 황수영
 * @fileName : Badge
 * @since : 2024-01-24
 * 내용 : 뱃지 도메인
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Badge {
    private int id;
    private String name;
    private String image;
    private String description;
}