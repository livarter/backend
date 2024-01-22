package com.livarter.app.security.dto;

import lombok.*;

/**
 * @author : 황수영
 * @fileName : TokenDto
 * @since : 2024-01-19
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