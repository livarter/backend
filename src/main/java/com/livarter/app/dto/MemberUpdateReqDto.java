package com.livarter.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : 황수영
 * @fileName : MemberUpdateReqDto
 * @since : 2024-01-22
 * 내용 : 회원 정보 수정 DTO
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateReqDto {
    private int id;
    private String image;
    private String phone;
    private String name;
    private String nickname;
    private String address;
    private String zipCode;
    private String birthDate;
}