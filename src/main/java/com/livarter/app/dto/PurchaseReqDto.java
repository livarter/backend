package com.livarter.app.dto;

import lombok.*;

import java.util.List;

/**
 * @author : 변형준
 * @fileName : PurchaseResDto
 * @since : 1/23/24
 * @작업내용 : 주문내역 조회 응답 dto
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReqDto {
    private int memberId;
    private String receiptId;
    private String createdAt;
    private String address;
    private String zipcode;
    private String receiverName;
    private String receiverPhone;
    private String purchaseDetailStatus;
    private List<Item> items;


    @Getter
    @NoArgsConstructor
    public static class Item {
        private int id;
        private int qty;
        private int price;
    }
}
