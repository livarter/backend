package com.livarter.app.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author : 오수영
 * @fileName : Product$
 * @since : 2024-01-22
 */

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)@Data
public class Product {
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private String productImage;
    private String brandName;
    private String hashtags;
    private String allHashtags;
}