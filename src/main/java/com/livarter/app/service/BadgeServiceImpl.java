package com.livarter.app.service;

import com.livarter.app.domain.BadgeMember;
import com.livarter.app.dto.BadgeMemberListDto;
import com.livarter.app.mapper.BadgeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : BadgeServiceImpl
 * @since : 2024-01-24
 */

@Log4j
@Service
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    private final BadgeMapper badgeMapper;

    public BadgeMemberListDto getBadgesByMember(String id) {
        List<BadgeMember> badges = badgeMapper.getBadgesByMember(Integer.parseInt(id));
        return new BadgeMemberListDto(badges);
    }

    // 회원 가입 시 기본 뱃지들 전체 셋팅
    public void createBadges(String id) {
        for (int i = 1; i <= 9; i++) {
            badgeMapper.createBadges(i, Integer.parseInt(id));
        }
    }
}