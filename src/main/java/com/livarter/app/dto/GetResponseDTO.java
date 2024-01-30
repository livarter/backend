package com.livarter.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author : 오수영
 * @fileName : ProductResDto
 * @since : 2024-01-22$
 * @Function : 상품 조회 요청에 대한 응답으로 전달되는 데이터 전송 객체(DTO)
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
