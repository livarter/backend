package com.livarter.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : 황수영
 * @fileName : MemberGradeDto
 * @since : 2024-01-25
 */

@Getter
@NoArgsConstructor
public class MemberGradeDto {
    int curPoint;
    int totalPoint;
    String name;
    String image;
}