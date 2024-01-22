package com.livarter.app.domain.enumType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : 황수영
 * @fileName : Header
 * @since : 2024-01-22
 */
@Getter
@AllArgsConstructor
public enum Header {
    AUTH("Authorization"),
    BEARER("Bearer ");
    private final String value;
}
