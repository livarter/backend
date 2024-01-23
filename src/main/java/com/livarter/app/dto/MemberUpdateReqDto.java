package com.livarter.app.dto;

import com.livarter.app.domain.enumType.Grade;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : 황수영
 * @fileName : MemberUpdateReqDto
 * @since : 2024-01-22
 */

@Getter
@NoArgsConstructor
public class MemberUpdateReqDto {

    private int id;
    private String email;
    private String nickname;
    private String image;
    private Grade grade;

    private String name;
    private String address;
    private String zipCode;
    private String birthDate;
}