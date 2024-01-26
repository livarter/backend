package com.livarter.app.domain;

import lombok.*;

/**
 * @author : 황수영
 * @fileName : BadgeMember
 * @since : 2024-01-24
 */

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BadgeMember {
    private int id;
    private int memberId;
    private int badgeId;
    private Boolean isEarned;

    private String name;
    private String image;
}