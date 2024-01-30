package com.livarter.app.security.dto;

import lombok.*;

/**
 * @author : 황수영
 * @fileName : TokenDto
 * @since : 2024-01-19
 * 내용 : 프론트에서 로그인 후 Res DTO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResDto {

    private String accessToken;

    private String refreshToken;
}