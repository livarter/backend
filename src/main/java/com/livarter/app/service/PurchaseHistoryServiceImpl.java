package com.livarter.app.service;

import com.livarter.app.domain.PurchaseHistory;
import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseResDto;
import com.livarter.app.mapper.PurchaseHistoryMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : 변형준
 * @fileName :PurchaseHistoryServiceImpl
 * @since : 2024-01-23
 */
@Log4j
@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistroryService {

    @Autowired
    private PurchaseHistoryMapper purchaseHistoryMapper;

    public void savePurchaseHistory(PurchaseHistoryResDto purchaseHistoryResDto) {
        PurchaseHistory purchaseHistory = PurchaseHistory.builder()
                .id(1)
                .memberId(purchaseHistoryResDto.getMemberId())
                .createdAt(purchaseHistoryResDto.getCreatedAt())
                .address(purchaseHistoryResDto.getAddress())
                .zipcode(purchaseHistoryResDto.getZipcode())
                .receiverName(purchaseHistoryResDto.getReceiverName())
                .receiverPhone(purchaseHistoryResDto.getReceiverPhone())
                .purchaseDetailStatus(purchaseHistoryResDto.getPurchaseDetailStatus())
                .receiptId(purchaseHistoryResDto.getReceiptId())
                .build();

        purchaseHistoryMapper.savePurchaseHistory(purchaseHistory);
    }

}
