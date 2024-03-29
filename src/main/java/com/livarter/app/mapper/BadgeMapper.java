package com.livarter.app.mapper;

import com.livarter.app.domain.Badge;
import com.livarter.app.dto.BadgeMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : BadgeMapper
 * @since : 2024-01-24
 * 내용 : 뱃지 관련 Mapper
 */
public interface BadgeMapper {

    // 사용자의 뱃지 부여 조회
    List<BadgeMember> getBadgesByMember(int memberId);
    // 회원 가입 시 뱃지 전체 부여
    void createBadges(@Param("badgeId") int badgeId, @Param("memberId") int memberId);
    void earedBadge(@Param("badgeId") int badgeId, @Param("memberId") int memberId);
    Badge getBadge(@Param("badgeId") int badgeId);
}