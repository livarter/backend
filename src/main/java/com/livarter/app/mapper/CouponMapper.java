package com.livarter.app.mapper;

import com.livarter.app.dto.CouponResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : CouponMapper
 * @since : 2024-01-24
 */
public interface CouponMapper {

    List<CouponResDto> getCouponsByMemberId(int memberId);
    void removeCoupon(@Param("couponId")int couponId, @Param("memberId")int memberId);
}