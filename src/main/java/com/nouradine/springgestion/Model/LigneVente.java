package com.nouradine.springgestion.Model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


import java.math.BigDecimal;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idvente")
    private Vente vente;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name="identreprise")
    private Integer Identreprise;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

  

}
