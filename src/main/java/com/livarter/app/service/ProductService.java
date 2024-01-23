package com.livarter.app.service;

import java.util.List;

import com.livarter.app.dto.GetRequestDTO;
import com.livarter.app.dto.GetResponseDTO;

import javax.transaction.Transactional;

/**
 * @author : 오수영
 * @fileName : ProductService$
 * @since : 2024-01-22$
 */
public interface ProductService {
    List<GetResponseDTO> getProducts(GetRequestDTO requestDTO);

}