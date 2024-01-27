package com.livarter.app.membership.dto;

import com.livarter.app.domain.Badge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

/**
 * @author : 황수영
 * @fileName : PopUpDto
 * @since : 2024-01-27
 * 쿠폰 혹은 뱃지 팝업 띄워주는 용도
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PopUpDto {
    private String name;
    private String image;
    private String description;

    public static PopUpDto of(Badge badge) {
        PopUpDto popUpDto = new PopUpDto();
        popUpDto.name = badge.getName();
        popUpDto.image = badge.getImage();
        popUpDto.description = badge.getDescription();
        return popUpDto;
    }
}