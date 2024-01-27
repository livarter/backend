package com.livarter.app.mapper;

import com.livarter.app.domain.HistoryDetail;
import com.livarter.app.domain.Reply;
import com.livarter.app.dto.GetReplyDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author : 최현서
 * @fileName : ReplyMapper$
 * @since : 2024-01-25$
 */
@Mapper
public interface ReplyMapper {
    List<GetReplyDto> findAllByProductId(String productId);
    int saveReply(Reply reply);

    List<Reply> findAllByMemberId(int memberId);
}
