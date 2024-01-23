package com.livarter.app.service;

import com.livarter.app.domain.HistoryDetail;
import com.livarter.app.domain.PurchaseHistory;
import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseResDto;
import com.livarter.app.mapper.PurchaseHistoryMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Transactional
    public int savePurchaseHistory(PurchaseResDto purchaseResDto) {

        String datetime = purchaseResDto.getCreatedAt();
        String[] parts = datetime.split("\\+");
        String dateWithoutTimezone = parts[0];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime createdAt = LocalDateTime.parse(dateWithoutTimezone, formatter);

        PurchaseHistory purchaseHistory = PurchaseHistory.builder()
                .id(1)
                .memberId(purchaseResDto.getMemberId())
                .createdAt(createdAt)
                .address(purchaseResDto.getAddress())
                .zipcode(purchaseResDto.getZipcode())
                .receiverName(purchaseResDto.getReceiverName())
                .receiverPhone(purchaseResDto.getReceiverPhone())
                .purchaseDetailStatus(purchaseResDto.getPurchaseDetailStatus())
                .receiptId(purchaseResDto.getReceiptId())
                .build();

        purchaseHistoryMapper.savePurchaseHistory(purchaseHistory);

        int purchaseHistoryId = purchaseHistoryMapper.findId(purchaseResDto.getReceiptId());

        HistoryDetail historyDetail;
        for(int i = 0; i < purchaseResDto.getItems().size(); i++) {
            historyDetail = HistoryDetail.builder()
                    .purchaseHistoryId(purchaseHistoryId)
                    .productId(purchaseResDto.getItems().get(i).getId())
                    .memberId(purchaseResDto.getMemberId())
                    .productCnt(purchaseResDto.getItems().get(i).getQty())
                    .productPrice(purchaseResDto.getItems().get(i).getPrice())
                    .build();
            purchaseHistoryMapper.saveHistoryDetail(historyDetail);
        }

        return purchaseHistoryMapper.findId(purchaseResDto.getReceiptId());
    }


}
