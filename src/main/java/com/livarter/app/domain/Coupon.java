package com.livarter.app.domain;

import lombok.*;

/**
 * @author : 황수영
 * @fileName : Coupon
 * @since : 2024-01-24
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    private int id;
    private String name;
    private String image;
}