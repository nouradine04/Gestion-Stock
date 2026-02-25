package com.nouradine.springgestion.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nouradine.springgestion.Model.Article;
import com.nouradine.springgestion.Model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategoryDto {
    private  Long id;
    private String code;

    private String designation;

    private Integer idEntreprise;
    @JsonIgnore
    private List<ArticleDto> articlesDto;
// elle retourne un tyoe categoryDto pui en parametre un category puis nous verifions si c pas nul
public static CategoryDto fromEntity(Category category) {
    if (category == null) {
        return null;
        // TODO throw an exception
    }

    return CategoryDto.builder()
            .id(category.getId())
            .code(category.getCode())
            .designation(category.getDesignation())
            .idEntreprise(category.getIdEntreprise())
            .build();
}

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
            // TODO throw an exception
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        category.setIdEntreprise(categoryDto.getIdEntreprise());

        return category;
    }
}
