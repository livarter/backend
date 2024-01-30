package com.livarter.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 오수영
 * @fileName : SearchRequestDTO$
 * @since : $
 * @Function : 상품 검색 요청을 위한 데이터 전송 객체(DTO)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRequestDTO {
    private String category;   // 제품 카테고리
    private String brand;      // 브랜드명
    private String hashtag;    // 해시태그
    private String title;      // 제품 이름
    private Integer sortOption; // 정렬 옵션
    private Integer pageSize;  // 페이지 크기
    private Integer pageNumber; // 페이지 번호
}
