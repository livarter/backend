package com.livarter.app.dto;

import com.livarter.app.domain.PurchaseHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : 변형준
 * @fileName : PurchaseResDto
 * @since : 1/23/24
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseHistoryResDto {
    private int memberId;
    private LocalDateTime createdAt;
    private String address;
    private String zipcode;
    private String receiverName;
    private String receiverPhone;
    private String purchaseDetailStatus;
    private String receiptId;

    public PurchaseHistory toEntity() {
        return PurchaseHistory.builder()
                .memberId(memberId)
                .createdAt(createdAt)
                .address(address)
                .zipcode(zipcode)
                .receiverName(receiverName)
                .receiverPhone(receiverPhone)
                .purchaseDetailStatus(purchaseDetailStatus)
                .receiptId(receiptId)
                .build();
    }
}
