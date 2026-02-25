package com.nouradine.springgestion.Model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse implements Serializable {

    @Column(name = "adresse1")
    private String adresse1;

    @Column(name = "adresse2")
    private String adresse2;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codepostale")
    private String codePostale;

    @Column(name = "pays")
    private String pays;

    @Column(name="identreprise")
    private Integer Identreprise;

}