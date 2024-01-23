package com.livarter.app.service;

import com.livarter.app.dto.GetRequestDTO;
import com.livarter.app.dto.GetResponseDTO;
import com.livarter.app.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : 오수영
 * @fileName : ProductServiceImpl$
 * @since : 2024-01-22$
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
