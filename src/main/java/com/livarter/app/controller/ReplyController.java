package com.livarter.app.controller;

import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.dto.PurchaseReqDto;
import com.livarter.app.dto.ReplyDto;
import com.livarter.app.service.PurchaseHistroryService;
import com.livarter.app.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 최현서
 * @fileName : ReplyController
 * @since : 1/23/24
 */

@Log4j
@RequestMapping("/api/v1/reply")
@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping(value = "/{productId}")
    public ResponseEntity<List<ReplyDto>> getPurchaseHistory(@PathVariable String productId) {
        log.debug("댓글내역 조회 : " + productId);

        List<ReplyDto> list = replyService.findAllByProductId(productId);
        return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
    }
}
