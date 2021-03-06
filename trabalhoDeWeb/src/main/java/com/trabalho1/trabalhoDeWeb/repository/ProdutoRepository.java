package com.trabalho1.trabalhoDeWeb.repository;

import com.trabalho1.trabalhoDeWeb.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
