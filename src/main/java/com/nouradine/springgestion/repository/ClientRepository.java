package com.nouradine.springgestion.repository;

import com.nouradine.springgestion.Model.Article;
import com.nouradine.springgestion.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Long, Client> {
}
