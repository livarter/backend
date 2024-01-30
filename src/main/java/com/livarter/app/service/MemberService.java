package com.livarter.app.service;

import com.livarter.app.domain.Catalog;
import com.livarter.app.domain.Member;
import com.livarter.app.domain.enumType.Grade;
import com.livarter.app.domain.enumType.Header;
import com.livarter.app.domain.enumType.Nickname;
import com.livarter.app.domain.enumType.Role;
import com.livarter.app.dto.*;
import com.livarter.app.mapper.BadgeMapper;
import com.livarter.app.mapper.MemberMapper;
import com.livarter.app.security.AuthTokenGenerator;
import com.livarter.app.security.KakaoOauthClient;
import com.livarter.app.security.dto.LoginReqDto;
import com.livarter.app.security.dto.LoginResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : MemberService
 * @since : 2024-01-19
 */
@Log4j
@Service
@RequiredArgsConstructor
public class MemberService {

    @Value("${jwt.access-validity}")
    private long accessValidity;

    private final MemberMapper memberMapper;
    private final BadgeMapper badgeMapper;
    private final KakaoOauthClient oAuthClient;
    private final AuthTokenGenerator authTokenGenerator;

    public MemberResDto getMember(String id) {
        Member member = memberMapper.findById(Integer.parseInt(id));
        return MemberResDto.of(member);
    }

    public LoginResDto login(LoginReqDto loginReqDto) {
        String email = oAuthClient.getEmail(loginReqDto);

        Member findMember = memberMapper.findByEmail(email);
        if (findMember != null) {
            return getUpdatedToken(findMember);
        }
        return joinByEmail(email);
    }

        private String updateAccessToken(Member member) {
            String memberId = String.valueOf(member.getId());
            return authTokenGenerator.createJwtToken(memberId, accessValidity);
    }

    private LoginResDto getUpdatedToken(Member member) {
        String newAccessToken = updateAccessToken(member);
        String refreshToken = member.getRefreshToken();

        return LoginResDto.builder()
                .accessToken(Header.BEARER.getValue() + newAccessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public LoginResDto joinByEmail(String email) {
        Member member = Member.builder()
                .email(email)
                .nickname(Nickname.getRandomNickname())
                .role(Role.ROLE_MEMBER)
                .grade(Grade.BEGINNER)
                .build();
        memberMapper.saveMember(member);


        Member savedMember = memberMapper.findByEmail(email);
        int memberId = savedMember.getId();
        for (int i = 1; i <= 9; i++) {
            badgeMapper.createBadges(i, memberId);
        }

        LoginResDto loginResDto = authTokenGenerator.createLoginResDto(String.valueOf(memberId));
        savedMember.updateRefreshToken(loginResDto.getRefreshToken());
        memberMapper.updateRefreshToken(savedMember);

        log.trace("joinByEmail savedMember" + savedMember);
        return loginResDto;
    }

    public MemberResDto updateMember(String id, MemberUpdateReqDto memberUpdateReqDto) {
        int memberId = Integer.parseInt(id);
        memberUpdateReqDto.setId(memberId);
        memberMapper.updateMember(memberUpdateReqDto);
        Member member = memberMapper.findById(memberId);
        return MemberResDto.of(member);
    }

    // 멤버십 조회하기
    public MemberGradeDto getMemberGradeInfo(String id) {
        MemberGradeDto memberGradeDto = memberMapper.getMemberGradeInfo(Integer.parseInt(id));
        log.debug("멤버십 조회하기 서바스단 memberGradeDto : " + memberGradeDto);
        return memberGradeDto;
    }

    // 포인트 적립
    public int increasePoint(int money, String id) {
        // 멤버 grade에 따라서 포인트 다르게 적립됨

        // grade 찾기
        MemberGradeDto memberGradeDto = memberMapper.getMemberGradeInfo(Integer.parseInt(id));
        String gradeType = memberGradeDto.getName();
        log.debug("increasePoint ROLE : " + gradeType);
        Grade grade = Grade.valueOf(gradeType);
        int point = grade.getPointOfMoneyByGrade(money);
        log.debug("increasePoint money : " + money + " => point : " + point);
        memberMapper.increasePoint(point, Integer.parseInt(id));
        return point;
    }

    // 포인트 사용
    public void decreasePoint(int point, String id) {
        // 그냥 해당 값을 차감
        log.debug("decreasePoint point : " + point);
        memberMapper.decreasePoint(point, Integer.parseInt(id));
    }

    public  List<Catalog> getCatalogs() {
        List<Catalog> catalogs = memberMapper.getCatalogs();
        log.debug("getCatalogs : " + catalogs);
        return  catalogs;
    }
}