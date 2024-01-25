package com.livarter.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : 황수영
 * @fileName : BadgeDetailResDto
 * @since : 2024-01-24
 */

@Getter
@NoArgsConstructor
public class BadgeResDto {

    private int id;
    private String name;
    private String image;
    private boolean isEarned;
}
