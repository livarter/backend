package com.livarter.app.controller;

import com.livarter.app.dto.GetRequestDTO;
import com.livarter.app.dto.GetResponseDTO;
import com.livarter.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author : 오수영
 * @fileName : ProductController$
 * @since : 2024-01-22$
 * @Function : 상품 관련 요청을 처리하는 컨트롤러
 */

@Log4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    /**
     * @param category 카테고리
     * @param brand 브랜드
     * @param hashtag 해시태그
     * @param title 제목
     * @param sortOption 정렬 옵션
     * @param pageSize 페이지 크기
     * @param pageNumber 페이지 번호
     * @return 상품 목록
     */
    @GetMapping
    public List<GetResponseDTO> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String hashtag,
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "1") Integer sortOption,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNumber) throws UnsupportedEncodingException {

        // 인코딩된 문자열 디코딩
        if (category != null) {
            category = URLDecoder.decode(category, StandardCharsets.UTF_8.name());
        }
        if (brand != null) {
            brand = URLDecoder.decode(brand, StandardCharsets.UTF_8.name());
        }
        if (hashtag != null) {
            hashtag = URLDecoder.decode(hashtag, StandardCharsets.UTF_8.name());
        }
        if (title != null) {
            title = URLDecoder.decode(title, StandardCharsets.UTF_8.name());
        }

        GetRequestDTO requestDTO = new GetRequestDTO(category, brand, hashtag, title, sortOption, pageSize, pageNumber);
        log.info("getProducts 컨트롤러 시작" + requestDTO);
        return productService.getProducts(requestDTO);
    }

}
