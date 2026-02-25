package com.nouradine.springgestion.Dto;

import com.nouradine.springgestion.Model.Article;
import com.nouradine.springgestion.Model.LigneVente;
import com.nouradine.springgestion.Model.Vente;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Data
@Builder
public class LigneVenteDto {
    private  Long id;


    private VenteDto vente;


    private ArticleDto article;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;


    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VenteDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idEntreprise(ligneVente.getIdentreprise())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto dto) {
        if (dto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(dto.getId());
        ligneVente.setVente(VenteDto.toEntity(dto.getVente()));
        ligneVente.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneVente.setQuantite(dto.getQuantite());
        ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
        ligneVente.setIdentreprise(dto.getIdEntreprise());
        return ligneVente;
    }
}
