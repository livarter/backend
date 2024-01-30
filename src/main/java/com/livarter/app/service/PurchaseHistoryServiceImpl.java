package com.livarter.app.service;

import com.livarter.app.domain.HistoryDetail;
import com.livarter.app.domain.PurchaseHistory;
import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseReqDto;
import com.livarter.app.mapper.PurchaseHistoryMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author : 변형준
 * @fileName :PurchaseHistoryServiceImpl
 * @since : 2024-01-23
 * @작업내용 : 주문내역 저장 및 조회 serviceImpl
 */
@Log4j
@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistroryService {

    @Autowired
    private PurchaseHistoryMapper purchaseHistoryMapper;

    @Transactional
    public int savePurchaseHistory(PurchaseReqDto purchaseReqDto, String authId) {

        String datetime = purchaseReqDto.getCreatedAt();
        String[] parts = datetime.split("\\+");
        String dateWithoutTimezone = parts[0];
        int memberId = Integer.parseInt(authId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime createdAt = LocalDateTime.parse(dateWithoutTimezone, formatter);

        PurchaseHistory purchaseHistory = PurchaseHistory.builder()
                .id(1)
                .memberId(memberId)
                .createdAt(createdAt)
                .address(purchaseReqDto.getAddress())
                .zipcode(purchaseReqDto.getZipcode())
                .receiverName(purchaseReqDto.getReceiverName())
                .receiverPhone(purchaseReqDto.getReceiverPhone())
                .purchaseDetailStatus(purchaseReqDto.getPurchaseDetailStatus())
                .receiptId(purchaseReqDto.getReceiptId())
                .build();

        purchaseHistoryMapper.savePurchaseHistory(purchaseHistory);

        int purchaseHistoryId = purchaseHistoryMapper.findId(purchaseReqDto.getReceiptId());

        HistoryDetail historyDetail;
        for(int i = 0; i < purchaseReqDto.getItems().size(); i++) {
            historyDetail = HistoryDetail.builder()
                    .purchaseHistoryId(purchaseHistoryId)
                    .productId(purchaseReqDto.getItems().get(i).getId())
                    .memberId(memberId)
                    .productCnt(purchaseReqDto.getItems().get(i).getQty())
                    .productPrice(purchaseReqDto.getItems().get(i).getPrice())
                    .build();
            purchaseHistoryMapper.saveHistoryDetail(historyDetail);
        }

        return purchaseHistoryMapper.findId(purchaseReqDto.getReceiptId());
    }

    @Override
    public List<PurchaseHistoryResDto> findByMemberIdWithDetail(int memberId) {

        return purchaseHistoryMapper.findByMemberIdWithDetail(memberId);
    }


}
