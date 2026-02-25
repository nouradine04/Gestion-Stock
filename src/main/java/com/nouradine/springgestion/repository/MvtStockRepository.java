package com.nouradine.springgestion.repository;

import com.nouradine.springgestion.Model.Article;
import com.nouradine.springgestion.Model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStockRepository extends JpaRepository<Long, MvtStk> {
}
