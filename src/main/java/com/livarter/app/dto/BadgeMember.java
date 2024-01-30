package com.livarter.app.dto;

import lombok.*;

/**
 * @author : 황수영
 * @fileName : BadgeMember
 * @since : 2024-01-24
 * 내용 : 뱃지 DTO (회원이 부여 여부도 반환함)
 */

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BadgeMember {
    private boolean isEarned;
    private int id;
    private String name;
    private String image;
    private String description;
}