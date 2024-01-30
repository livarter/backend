package com.livarter.app.domain;

import lombok.*;


/**
 * @author : 변형준
 * @fileName : HistoryDetail
 * @since : 2024-01-23
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HistoryDetail {
    private int id;
    private int purchaseHistoryId;
    private int productId;
    private int memberId;
    private int productCnt;
    private int productPrice;
}
