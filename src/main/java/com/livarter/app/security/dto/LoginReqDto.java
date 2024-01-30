package com.livarter.app.security.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : 황수영
 * @fileName : LoginReqDto
 * @since : 2024-01-19
 * 내용 : 로그인 후 프론트에서의 Req DTO
 */
@Getter
@Setter
public class LoginReqDto {
    private String loginToken;
}