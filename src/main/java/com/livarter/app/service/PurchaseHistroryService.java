package com.livarter.app.service;

import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseReqDto;

import java.util.List;

/**
 * @author : 변형준
 * @fileName : PurchaseHistroryService
 * @since : 1/23/24
 * @작업내용 : 주문내역 저장 및 조회 service
 */
public interface PurchaseHistroryService {
    int savePurchaseHistory(PurchaseReqDto purchaseReqDto, String memberId);

    List<PurchaseHistoryResDto> findByMemberIdWithDetail(int memberId);

}
