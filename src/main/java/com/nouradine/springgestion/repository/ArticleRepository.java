package com.nouradine.springgestion.repository;

import com.nouradine.springgestion.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository  extends JpaRepository<Article,Long > {
    Optional<Article>findArticleByCodeArticle(String codeArticle);
}
