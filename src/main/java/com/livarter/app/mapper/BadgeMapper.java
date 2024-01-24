package com.livarter.app.mapper;

import com.livarter.app.domain.BadgeMember;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : BadgeMapper
 * @since : 2024-01-24
 */
public interface BadgeMapper {

    // 사용자의 뱃지 부여 조회
    List<BadgeMember> getBadgesByMember(int memberId);

}