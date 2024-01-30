package com.livarter.app.service;

import com.livarter.app.dto.GetMyReplyDto;
import com.livarter.app.dto.GetReplyDto;

import java.util.List;

/**
 * @author : 최현서
 * @fileName : ReplyService
 * @since : 2024-01-25
 */
public interface ReplyService {
    List<GetReplyDto> findAllByProductId(String productId);
    int saveReply(Long memberId, Long productId, String replyComment, String replyImg);

    List<GetMyReplyDto> findMyReview(int memberId);
}

