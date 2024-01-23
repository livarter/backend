package com.livarter.app.mapper;

import com.livarter.app.domain.Product;
import com.livarter.app.dto.GetRequestDTO;
import com.livarter.app.dto.GetResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 오수영
 * @fileName : ProductMapper$
 * @since : 2024-01-22$
 */
@Mapper
public interface ProductMapper {
    List<GetResponseDTO> getProducts(@Param("requestDTO") GetRequestDTO requestDTO);

}