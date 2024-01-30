package com.livarter.app.mapper;

import com.livarter.app.dto.GetRequestDTO;
import com.livarter.app.dto.GetResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 오수영
 * @fileName : ProductMapper$
 * @since : 2024-01-22$
 * @Function : 상품 데이터에 접근하기 위한 MyBatis 매퍼 인터페이스
 */
@Mapper
public interface ProductMapper {
    List<GetResponseDTO> getProducts(@Param("requestDTO") GetRequestDTO requestDTO);

}
