package com.trabalho1.trabalhoDeWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {

}

