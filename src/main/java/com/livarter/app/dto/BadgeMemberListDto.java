package com.livarter.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : BadgeResDto
 * @since : 2024-01-24
 */

@Getter
@AllArgsConstructor
public class BadgeMemberListDto {

    private List<BadgeMember> badges;
}