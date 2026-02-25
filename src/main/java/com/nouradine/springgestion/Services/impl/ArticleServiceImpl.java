package com.nouradine.springgestion.Services.impl;

import com.nouradine.springgestion.Dto.ArticleDto;
import com.nouradine.springgestion.Model.Article;
import com.nouradine.springgestion.Services.ArticleService;
import com.nouradine.springgestion.Validator.ArticleValidator;
import com.nouradine.springgestion.exception.EntityNotFoundException;
import com.nouradine.springgestion.exception.ErrorCodes;
import com.nouradine.springgestion.exception.InvalidEntityException;
import com.nouradine.springgestion.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository=articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors= ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("L'article est non valise {}",dto);
            throw new InvalidEntityException("l'article nest pas valide", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Long id) {
        if (id==null){
            log.info("L'id est null");
            return null;
        }
        Optional<Article> article=articleRepository.findById(id);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                 new EntityNotFoundException("Aucun article avec id"+id+ "existe ",ErrorCodes.ARTICLE_NOT_FOUND)

        );
    }

    @Override
    public ArticleDto findArticleByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.info("Article est null");
            return null;
        }
        Optional<Article> article=articleRepository.findArticleByCodeArticle(codeArticle);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun article avec ce code existe"+codeArticle+"dans la base",ErrorCodes.ARTICLE_NOT_FOUND)

        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id==null){
            log.info("L'id est null");

        }
       articleRepository.deleteById(id);
    }
}
