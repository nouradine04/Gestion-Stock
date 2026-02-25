package com.nouradine.springgestion.repository;

import com.nouradine.springgestion.Model.Article;
import com.nouradine.springgestion.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Long, Fournisseur> {
}
