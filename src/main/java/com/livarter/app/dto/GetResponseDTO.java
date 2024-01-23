package com.livarter.app.dto;

import com.livarter.app.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author : 오수영
 * @fileName : ProductResDto
 * @since : 2024-01-22$
 */
@Getter
@Setter
@NoArgsConstructor
public class GetResponseDTO {

    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private String productImage;
    private String brandName;
    private String hashtags;
    private String allHashtags;

}