package com.livarter.app.service;

import com.livarter.app.dto.BadgeMemberListDto;

/**
 * @author : 황수영
 * @fileName : BadgeService
 * @since : 2024-01-24
 * 내용 : 뱃지 관련 기능
 */

public interface BadgeService {
    BadgeMemberListDto getBadgesByMember(String id);

    void earedBadge(int badgeId, String memberId);
}