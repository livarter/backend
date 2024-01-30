package com.livarter.app.controller;


import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseReqDto;
import com.livarter.app.service.PurchaseHistroryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 변형준
 * @fileName : PurchaseController
 * @since : 1/23/24
 * @작업내용 : 주문내역 저장 및 조회 api
 */

@Log4j
@RequestMapping("/api/v1/purchase")
@RestController
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseHistroryService purchaseHistroryService;

    @PostMapping(value = "/insert")
    public ResponseEntity<String> insertPurchaseHistory(@RequestBody PurchaseReqDto purchaseReqDto,
                                                        Authentication authentication) {
        log.debug("구매내역 저장 : " + purchaseReqDto.getReceiptId());
        log.debug("회원아이디 : " + authentication.getName());

        int result = purchaseHistroryService.savePurchaseHistory(purchaseReqDto, authentication.getName());

        log.debug("주문번호 : " + result + "저장완료");
        return new ResponseEntity<> ("success", HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseHistoryResDto>> getPurchaseHistory(Authentication authentication) {
        log.debug("구매내역 조회 : " + authentication.getName());

        List<PurchaseHistoryResDto> list = purchaseHistroryService.findByMemberIdWithDetail(Integer.parseInt(authentication.getName()));
        return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
    }
}
