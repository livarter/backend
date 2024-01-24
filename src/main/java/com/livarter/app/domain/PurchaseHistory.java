package com.livarter.app.domain;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author : 변형준
 * @fileName : PurchaseHistory
 * @since : 2024-01-23
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PurchaseHistory {
    private int id;
    private int memberId;
    private LocalDateTime createdAt;
    private String address;
    private String zipcode;
    private String receiverName;
    private String receiverPhone;
    private String purchaseDetailStatus;
    private String receiptId;
}
