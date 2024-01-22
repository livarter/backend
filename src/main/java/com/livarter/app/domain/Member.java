package com.livarter.app.domain;

import com.livarter.app.domain.enumType.Grade;
import com.livarter.app.domain.enumType.Role;
import lombok.*;

import java.time.LocalDate;

/**
 * @author : 황수영
 * @fileName : Member
 * @since : 2024-01-19
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    private int id;
    private String email;
    private String nickname;
    private Role role;

    private String image;
    private String refreshToken;
    private Grade grade;

    private String name;
    private String address;
    private String zipCode;
    private LocalDate birthDate;

    private int curPoint;
    private int totalPoint;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}