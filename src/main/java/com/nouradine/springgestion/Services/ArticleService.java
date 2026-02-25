package com.nouradine.springgestion.Services;

import com.nouradine.springgestion.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);
    ArticleDto findById(Long id);
    ArticleDto findArticleByCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    void delete(Long id);
}
