package com.livarter.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : 최현서
 * @fileName : ReplyDto
 * @since : 2024-01-25
 */

@Getter
@NoArgsConstructor
public class GetReplyDto {
    private Long replyId;
    private Long productId;
    private String nickname;
    private Long memberId;
    private String replyComment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int isDeleted;
    private String replyImg;
}
