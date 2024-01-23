package com.livarter.app.service;

import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseResDto;

/**
 * @author : 변형준
 * @fileName : PurchaseHistroryService
 * @since : 1/23/24
 */
public interface PurchaseHistroryService {
    int savePurchaseHistory(PurchaseResDto purchaseResDto);

}
