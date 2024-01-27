package com.livarter.app.dto;

import com.livarter.app.domain.enumType.Grade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : 황수영
 * @fileName : MemberUpdateReqDto
 * @since : 2024-01-22
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateReqDto {
    private int id;
    private String image;
    private String name;
    private String nickname;
    private String address;
    private String zipCode;
    private String birthDate;
}