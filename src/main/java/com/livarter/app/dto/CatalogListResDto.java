package com.livarter.app.dto;

import com.livarter.app.domain.BadgeMember;
import com.livarter.app.domain.Catalog;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author : 황수영
 * @fileName : CatalogListResDto
 * @since : 2024-01-28
 */
@Getter
@AllArgsConstructor
public class CatalogListResDto {

    private List<Catalog> catalogs;
}