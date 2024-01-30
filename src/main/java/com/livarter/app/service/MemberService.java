package com.livarter.app.service;

import com.livarter.app.domain.Catalog;
import com.livarter.app.dto.MemberGradeDto;
import com.livarter.app.dto.MemberResDto;
import com.livarter.app.dto.MemberUpdateReqDto;
import com.livarter.app.security.dto.LoginReqDto;
import com.livarter.app.security.dto.LoginResDto;

import java.util.List;

public interface MemberService {

    MemberResDto getMember(String id);

    LoginResDto login(LoginReqDto loginReqDto);

    LoginResDto joinByEmail(String email);

    MemberResDto updateMember(String id, MemberUpdateReqDto memberUpdateReqDto);

    // 멤버십 조회하기
    MemberGradeDto getMemberGradeInfo(String id) ;

    // 포인트 적립
    int increasePoint(int money, String id);

    // 포인트 사용
    void decreasePoint(int point, String id);

    List<Catalog> getCatalogs();
}