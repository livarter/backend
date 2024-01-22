package com.livarter.app.mapper;

import com.livarter.app.domain.Member;

public interface MemberMapper {
    void saveMember(Member member);
    Member findById(int id);
    Member findByEmail(String email);
    void updateRefreshToken(Member member);
}