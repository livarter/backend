package com.livarter.app.domain.enumType;

import lombok.Getter;

/**
 * @author : 황수영
 * @fileName : Role
 * @since : 2024-01-19
 * 내용 : 회원 타입
 */
@Getter
public enum Role {
    ROLE_MEMBER, ROLE_ARTEST, ROLE_LIARTEST, ROLE_ADMIN, ROLE_GUEST;
}