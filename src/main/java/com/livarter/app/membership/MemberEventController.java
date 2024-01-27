package com.livarter.app.membership;

import com.livarter.app.membership.dto.PopUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @author : 황수영
 * @fileName : EventController
 * @since : 2024-01-26
 */

@Log4j
@RequestMapping("/api/v1/event")
@RestController
@RequiredArgsConstructor
public class MemberEventController {

    private final MemberEventHandler membershipEventHandler;
    @PostMapping("/first-purchase")
    public ResponseEntity<PopUpDto> issueBadgeIfFirstPurchase(Authentication authentication) {
        log.debug("첫 구매일 경우, 회원 아이디: " + authentication.getName());
        PopUpDto popUpDto = membershipEventHandler.issueBadgeIfFirstPurchase(authentication.getName());
        log.debug("첫 댓글 작성 시, popUpDto: " + popUpDto);
        return new ResponseEntity<>(popUpDto, HttpStatus.ACCEPTED);
    }

    @PostMapping("/first-comment")
    public ResponseEntity<PopUpDto> issueBadgeIfFirstReview(Authentication authentication) {
        log.debug("첫 댓글 작성 시, 회원 아이디: " + authentication.getName());
        PopUpDto popUpDto = membershipEventHandler.issueBadgeIfFirstReview(authentication.getName());
        log.debug("첫 댓글 작성 시, popUpDto " + popUpDto);
        return new ResponseEntity<>(popUpDto, HttpStatus.ACCEPTED);
    }
}