package com.livarter.app.mapper;

import com.livarter.app.domain.Member;
import com.livarter.app.dto.MemberUpdateReqDto;

public interface MemberMapper {
    void saveMember(Member member);
    Member findById(int id);
    Member findByEmail(String email);
    void updateRefreshToken(Member member);

    void updateMember(MemberUpdateReqDto memberUpdateReqDto);
}