package com.livarter.app.mapper;

import com.livarter.app.domain.HistoryDetail;
import com.livarter.app.domain.PurchaseHistory;
import com.livarter.app.dto.PurchaseHistoryResDto;

import java.util.List;

/**
 * @author : 변형준
 * @fileName : PurchaseHistoryMapper
 * @since : 2024-01-23
 */
public interface PurchaseHistoryMapper {
    int savePurchaseHistory(PurchaseHistory purchaseHistory);

    int findId(String receiptId);

    int saveHistoryDetail(HistoryDetail historyDetail);

    List<PurchaseHistoryResDto> findByMemberIdWithDetail(int memberId);

}
