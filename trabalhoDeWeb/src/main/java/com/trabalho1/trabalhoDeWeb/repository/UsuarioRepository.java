package com.trabalho1.trabalhoDeWeb.repository;

import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Object getLogin();

    Object getSenha();
}
