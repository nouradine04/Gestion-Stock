package com.nouradine.springgestion.Model;


import java.time.Instant;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ventes")
public class Vente extends AbstractEntity {


    @Column(name = "code")
    private String code;

    @Column(name="identreprise")
    private Integer Identreprise;

    @Column(name = "datevente")
    private Instant dateVente;

    @Column(name = "commentaire")
    private String commentaire;



    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;

}
