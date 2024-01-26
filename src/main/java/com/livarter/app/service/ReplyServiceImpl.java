package com.livarter.app.service;

import com.livarter.app.domain.PurchaseHistory;
import com.livarter.app.domain.Reply;
import com.livarter.app.dto.GetReplyDto;
import com.livarter.app.mapper.ReplyMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 최현서
 * @fileName : ReplyServiceImpl
 * @since : 2024-01-25
 */

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    @Autowired
    public ReplyServiceImpl(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }
    @Override
    public List<GetReplyDto> findAllByProductId(String productId) {

        log.info("ReplyServiceImpl findAllByProductId : " + productId);
        return replyMapper.findAllByProductId(productId);
    }

    @Override
    public int saveReply(Long memberId, Long productId, String replyComment) {
        Reply reply = Reply.builder()
                .memberId(memberId)
                .productId(productId)
                .replyComment(replyComment)
                .build();
        return replyMapper.saveReply(reply);
    }
}