package com.livarter.app.service;

import com.livarter.app.dto.CouponListResDto;
import com.livarter.app.dto.CouponResDto;
import com.livarter.app.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : CouponServiceImpl
 * @since : 2024-01-24
 */

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponMapper couponMapper;

    public CouponListResDto getCouponsByMemberId(String memberId) {
        List<CouponResDto> couponResDtos = couponMapper.getCouponsByMemberId(Integer.parseInt(memberId));
        return new CouponListResDto(couponResDtos);
    }

    @Transactional
    public void removeCoupon(int couponId, String memberId) {
        couponMapper.removeCoupon(couponId, Integer.parseInt(memberId));
    }
}