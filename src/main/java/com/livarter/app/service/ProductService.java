package com.livarter.app.service;

import java.util.List;

import com.livarter.app.dto.GetRequestDTO;
import com.livarter.app.dto.GetResponseDTO;


/**
 * @author : 오수영
 * @fileName : ProductService$
 * @since : 2024-01-22$
 * @Function : 상품 관련 비즈니스 로직을 처리하는 서비스 인터페이스
 */
public interface ProductService {
    List<GetResponseDTO> getProducts(GetRequestDTO requestDTO);

}
