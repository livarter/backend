package com.livarter.app.domain;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author : 최현서
 * @fileName : Reply$
 * @since : 2024-01-25
 */

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)@Data
public class Reply {
    private Long replyId;
    private Long productId;
    private Long memberId;
    private String replyComment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int isDeleted;
}
