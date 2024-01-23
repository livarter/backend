package com.livarter.app.mapper;

import com.livarter.app.domain.PurchaseHistory;

import java.util.List;

/**
 * @author : 변형준
 * @fileName : PurchaseHistoryMapper
 * @since : 2024-01-23
 */
public interface PurchaseHistoryMapper {
    void savePurchaseHistory(PurchaseHistory purchaseHistory);
    List<PurchaseHistory> selectPurchaseHistoryByMemberId(int memberId);

}
