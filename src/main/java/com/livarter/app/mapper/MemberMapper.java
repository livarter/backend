package com.livarter.app.mapper;

import com.livarter.app.domain.Catalog;
import com.livarter.app.domain.Member;
import com.livarter.app.dto.MemberGradeDto;
import com.livarter.app.dto.MemberUpdateReqDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : EventService
 * @since : 2024-01-26
 * 내용 : 회원 관련 Mapper
 */
public interface MemberMapper {
    // 회원 가입 및 인증 관련
    void saveMember(Member member);
    Member findById(int id);
    Member findByEmail(String email);
    void updateRefreshToken(Member member);
    void updateMember(MemberUpdateReqDto memberUpdateReqDto);

    // 멤버십 관련
    MemberGradeDto getMemberGradeInfo(int memberId);
    void increasePoint(@Param("point") int point, @Param("memberId") int memberId);
    void decreasePoint(@Param("point") int point, @Param("memberId") int memberId);
    int countPurchaseHistoryByMemberId(@Param("memberId") int memberId);

    List<Catalog> getCatalogs(@Param("memberId") int memberId);
}