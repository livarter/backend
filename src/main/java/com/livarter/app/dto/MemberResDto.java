package com.livarter.app.dto;

import com.livarter.app.domain.Member;
import com.livarter.app.domain.enumType.Grade;
import com.livarter.app.domain.enumType.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : 황수영
 * @fileName : MemberResDto
 * @since : 2024-01-20
 */
@Getter
@NoArgsConstructor
public class MemberResDto {

    private String email;
    private String nickname;
    private Role role;
    private String image;
    private Grade grade;

    private String name;
    private String address;
    private String zipCode;
    private LocalDate birthDate;

    private int curPoint;
    private int totalPoint;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public static MemberResDto of(Member member) {
        MemberResDto memberResDto = new MemberResDto();
        memberResDto.email = member.getEmail();
        memberResDto.nickname = member.getNickname();
        memberResDto.role = member.getRole();
        memberResDto.image = member.getImage();
        memberResDto.grade = member.getGrade();

        memberResDto.name = member.getName();
        memberResDto.address = member.getAddress();
        memberResDto.zipCode = member.getZipCode();
        memberResDto.birthDate = member.getBirthDate();

        memberResDto.curPoint = member.getCurPoint();
        memberResDto.totalPoint = member.getTotalPoint();
        memberResDto.createdAt = member.getCreatedAt();
        memberResDto.updatedAt = member.getUpdatedAt();

        return memberResDto;
    }
}