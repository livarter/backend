package com.livarter.app.domain;

import lombok.*;

/**
 * @author : 황수영
 * @fileName : Catalog
 * @since : 2024-01-28
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Catalog {
    private int id;
    private String leftChair;
    private String rightChair;
    private String sofa;
    private String hashtag;
}
