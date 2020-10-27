package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.repository.UsuarioRepository;
import org.springframework.stereotype.Component;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import java.time.LocalDate;
import java.util.List;

@Component
public class LoginService {

    private UsuarioRepository usuarioRepository;

    public void login(String usuario,String senha){
        if (this.usuarioRepository.getLogin().equals(usuario) && this.usuarioRepository.getSenha().equals(senha)){

        }else {
            throw new RuntimeException("Usuário ou senha incorretos", null);
        }
    }

}
