package com.livarter.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author : 변형준
 * @fileName : PurchaseResDto
 * @since : 1/23/24
 */
@Getter
@NoArgsConstructor
public class PurchaseResDto {
    private int memberId;
    private String receiptId;
    private LocalDate createdAt;
    private String address;
    private String zipcode;
    private String receiverName;
    private String receiverPhone;
    private String purchaseDetailStatus;
    private List<Item> items;


    public static class Item {
        private int id;
        private int qty;
        private int price;
    }
}
