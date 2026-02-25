package com.nouradine.springgestion.Dto;

import com.nouradine.springgestion.Model.LigneVente;
import com.nouradine.springgestion.Model.Vente;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;
@Data
@Builder
public class VenteDto {
    private  Long id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private Integer idEntreprise;

    private List<LigneVenteDto> ligneVentes;

    public static VenteDto fromEntity(Vente vente) {
        if (vente == null) {
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdentreprise())
                .build();
    }

    public static Vente toEntity(VenteDto dto) {
        if (dto == null) {
            return null;
        }
        Vente ventes = new Vente();
        ventes.setId(dto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(dto.getCommentaire());
        ventes.setIdentreprise(dto.getIdEntreprise());
        return ventes;
    }
}
