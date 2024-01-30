package com.livarter.app.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : 변형준
 * @fileName : PurchaseResDto
 * @since : 1/23/24
 * @작업내용 : 주문내역 조회 응답 dto
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseHistoryResDto {
    private int id;
    private int memberId;
    private String createdAt;
    private String createdAtTime;
    private String address;
    private String zipcode;
    private String receiverName;
    private String receiverPhone;
    private String purchaseDetailStatus;
    private String receiptId;
    private int historyDetailId;
    private int productId;
    private int productCnt;
    private int productPrice;
    private String productName;
    private String productImage;
    private String productDesc;
    private String productBrand;
}
