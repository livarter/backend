package com.livarter.app.controller;

import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseResDto;
import com.livarter.app.service.PurchaseHistroryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author : 변형준
 * @fileName : PurchaseController
 * @since : 1/23/24
 */

@Log4j
@RequestMapping("/api/v1/purchase")
@RestController
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseHistroryService purchaseHistroryService;

    @PostMapping(value = "/insert")
    public void insertPurchaseHistory(@RequestBody PurchaseResDto purchaseResDto) {
        log.debug("구매내역 저장 : " + purchaseResDto.getReceiptId());
        PurchaseHistoryResDto purchaseHistoryResDto = PurchaseHistoryResDto.builder()
                .memberId(purchaseResDto.getMemberId())
                .createdAt(purchaseResDto.getCreatedAt())
                .address(purchaseResDto.getAddress())
                .zipcode(purchaseResDto.getZipcode())
                .receiverName(purchaseResDto.getReceiverName())
                .receiverPhone(purchaseResDto.getReceiverPhone())
                .purchaseDetailStatus(purchaseResDto.getPurchaseDetailStatus())
                .receiptId(purchaseResDto.getReceiptId())
                .build();
        purchaseHistroryService.savePurchaseHistory(purchaseHistoryResDto);
    }


}