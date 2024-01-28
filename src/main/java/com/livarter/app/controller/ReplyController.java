package com.livarter.app.controller;

import com.livarter.app.dto.GetMyReplyDto;
import com.livarter.app.dto.GetReplyDto;
import com.livarter.app.dto.PurchaseHistoryResDto;
import com.livarter.app.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @GetMapping
    public ResponseEntity<List<GetReplyDto>> findAllByProductId(@RequestParam String productId) {
        log.debug("댓글 조회 : " + productId);
        List<GetReplyDto> list = replyService.findAllByProductId(productId);
        return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
    }

    @GetMapping("/save")
    public ResponseEntity<String> saveReply(
            Authentication authentication,
            @RequestParam Long productId,
            @RequestParam String replyComment,
            @RequestParam(value = "replyImg", required = false) String replyImg) {
        int result  = replyService.saveReply(Long.parseLong(authentication.getName()), productId, replyComment, replyImg);
        log.debug("리뷰 등록 : " + Long.parseLong(authentication.getName()));
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<GetMyReplyDto>> findMyReview(Authentication authentication) {
        log.debug("나의 리뷰 조회 : " + authentication.getName());

        List<GetMyReplyDto> list = replyService.findMyReview(Integer.parseInt(authentication.getName()));
        return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
    }
}
