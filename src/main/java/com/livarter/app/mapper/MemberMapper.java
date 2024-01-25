package com.livarter.app.mapper;

import com.livarter.app.domain.Member;
import com.livarter.app.dto.MemberGradeDto;
import com.livarter.app.dto.MemberUpdateReqDto;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    void saveMember(Member member);
    Member findById(int id);
    Member findByEmail(String email);
    void updateRefreshToken(Member member);
    void updateMember(MemberUpdateReqDto memberUpdateReqDto);
    MemberGradeDto getMemberGradeInfo(int memberId);
    void increasePoint(@Param("point") int point, @Param("memberId") int memberId);
    void decreasePoint(@Param("point") int point, @Param("memberId") int memberId);
}