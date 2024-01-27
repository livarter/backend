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
    private boolean isEarned;
    private String name;
    private String image;
    private String description;
}