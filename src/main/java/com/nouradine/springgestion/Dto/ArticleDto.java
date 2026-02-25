package com.nouradine.springgestion.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nouradine.springgestion.Model.Adresse;
import com.nouradine.springgestion.Model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
@Builder
public class ArticleDto {
    private  Long id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

   private Integer idEntreprise;

    private CategoryDto category;
    @JsonIgnore
    private List<LigneVenteDto> ligneVentesDto;
    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClientsDto;
    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseursDto;
    @JsonIgnore
    private List<MvtStkDto> mvtStksDto;

    public static ArticleDto fromEntity(Article article){
        if(article==null){
            return null;
        }
        return ArticleDto.builder()
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .photo(article.getPhoto())
                .idEntreprise(article.getIdentreprise())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();

    }
    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPhoto(articleDto.getPhoto());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setIdentreprise(articleDto.getIdEntreprise());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
        return article;
    }

}
