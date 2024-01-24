package com.livarter.app.mapper;

import com.livarter.app.domain.BadgeMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : BadgeMapper
 * @since : 2024-01-24
 */
public interface BadgeMapper {

    // 사용자의 뱃지 부여 조회
    List<BadgeMember> getBadgesByMember(int memberId);

    // 회원 가입 시 뱃지 전체 부여
    void createBadges(@Param("badgeId") int badgeId, @Param("memberId") int memberId);

}