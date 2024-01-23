package com.livarter.app.service;

import com.livarter.app.domain.Member;
import com.livarter.app.domain.enumType.Grade;
import com.livarter.app.domain.enumType.Header;
import com.livarter.app.domain.enumType.Nickname;
import com.livarter.app.domain.enumType.Role;
import com.livarter.app.dto.MemberResDto;
import com.livarter.app.dto.MemberUpdateReqDto;
import com.livarter.app.mapper.MemberMapper;
import com.livarter.app.security.AuthTokenGenerator;
import com.livarter.app.security.KakaoOauthClient;
import com.livarter.app.security.dto.LoginReqDto;
import com.livarter.app.security.dto.LoginResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

        LoginResDto loginResDto = authTokenGenerator.createLoginResDto(String.valueOf(memberId));
        savedMember.updateRefreshToken(loginResDto.getRefreshToken());
        memberMapper.updateRefreshToken(savedMember);

        log.trace("joinByEmail savedMember" + savedMember);
        return loginResDto;
    }

    public MemberResDto updateMember(MemberUpdateReqDto memberUpdateReqDto) {
        memberMapper.updateMember(memberUpdateReqDto);
        Member member = memberMapper.findById(memberUpdateReqDto.getId());
        return MemberResDto.of(member);
    }
}