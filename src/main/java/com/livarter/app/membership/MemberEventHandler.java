package com.livarter.app.membership;

import com.livarter.app.domain.Reply;
import com.livarter.app.mapper.BadgeMapper;
import com.livarter.app.mapper.MemberMapper;
import com.livarter.app.mapper.ReplyMapper;
import com.livarter.app.membership.dto.BadgeType;
import com.livarter.app.membership.dto.PopUpDto;
import com.livarter.app.service.BadgeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import com.livarter.app.domain.Badge;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : MembershipEventHandler
 * @since : 2024-01-26
 * 쿠폰 및 뱃지 발급 가능한 조건 판별하는 용도
 */

@Log4j
@Component
@RequiredArgsConstructor
public class MemberEventHandler {
    private final ReplyMapper replyMapper;
    private final MemberMapper memberMapper;
    private final BadgeMapper badgeMapper;
    private final BadgeService badgeService;

    public PopUpDto issueBadgeIfFirstPurchase(String memberId) {
        if (isFirstPurchase(memberId)) {
            int badgeId = BadgeType.FIRST_PURCHASE.getId();
            log.debug("issueBadgeIfFirstReview badgeId : " + badgeId + " memberId : " + memberId);
            Badge badge = badgeMapper.getBadge(badgeId);
            badgeService.earedBadge(badgeId, memberId);
            return PopUpDto.of(badge);
        }
        return null;
    }

    private boolean isFirstPurchase(String memberId) {
        int purchaseHistoryCount = memberMapper.countPurchaseHistoryByMemberId(Integer.parseInt(memberId));
        if (purchaseHistoryCount > 0) {
            return false;
        }
        return true;
    }

    public PopUpDto issueBadgeIfFirstReview(String memberId) {
        if (isFirstReply(memberId)) {
            int badgeId = BadgeType.FIRST_REVIEW.getId();
            badgeService.earedBadge(badgeId, memberId);
            log.debug("issueBadgeIfFirstReview badgeId : " + badgeId + " memberId : " + memberId);
            Badge badge = badgeMapper.getBadge(badgeId);
            return PopUpDto.of(badge);
        }
        return null;
    }

    private boolean isFirstReply(String memberId) {
        List<Reply> replies = replyMapper.findAllByMemberId(Integer.parseInt(memberId));
        if (replies.isEmpty()) {
            return true;
        }
        return false;
    }
}
