package com.livarter.app.service;

import com.livarter.app.dto.GetRequestDTO;
import com.livarter.app.dto.GetResponseDTO;
import com.livarter.app.mapper.ProductMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 오수영
 * @fileName : ProductServiceImpl$
 * @since : 2024-01-22$
 * @Function : ProductService 인터페이스를 구현하여 상품 관련 비즈니스 로직을 실제로 처리하는 클래스
 */

@Log4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    @Override
    public List<GetResponseDTO> getProducts(GetRequestDTO requestDTO) {

        log.info("ProductServiceImpl getProducts : " + requestDTO);
        return productMapper.getProducts(requestDTO);
    }

}
