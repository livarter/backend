package com.livarter.app.membership;

import com.livarter.app.domain.Reply;
import com.livarter.app.mapper.MemberMapper;
import com.livarter.app.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : MembershipEventHandler
 * @since : 2024-01-26
 * 쿠폰 및 뱃지 발급 가능한 조건 판별하는 용도
 */

@Component
@RequiredArgsConstructor
public class MembershipEventHandler {
    private final ReplyMapper replyMapper;
    private final MemberMapper memberMapper;

    public boolean isFirstReply(String memberId) {
        List<Reply> replies = replyMapper.findAllByMemberId(Integer.parseInt(memberId));
        if (replies.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isFirstPurchase(String memberId) {
        int purchaseHistoryCount = memberMapper.countPurchaseHistoryByMemberId(Integer.parseInt(memberId));
        if (purchaseHistoryCount > 0) {
            return false;
        }
        return true;
    }
}
