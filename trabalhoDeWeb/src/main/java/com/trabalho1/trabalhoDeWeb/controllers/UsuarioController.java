package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.entity.Pedido;
import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.service.LoginService;
import com.trabalho1.trabalhoDeWeb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos(@RequestHeader("usuario") String usuario, @RequestHeader("senha") String senha){
        loginService.login(usuario,senha);
        return new ResponseEntity(usuarioService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@RequestHeader("usuario") String usuario, @RequestHeader("senha") String senha,@PathVariable("id") Long id){
        return new ResponseEntity(usuarioService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@RequestHeader("usuario") String usuario, @RequestHeader("senha") String senha,@PathVariable("id") Long id){
        loginService.login(usuario,senha);
        usuarioService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestHeader("usuario") String usuario, @RequestHeader("senha") String senha,@RequestBody Usuario usuariobody) {
        loginService.login(usuario,senha);
        return new ResponseEntity(usuarioService.salvar(usuariobody), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@RequestHeader("usuario") String usuario, @RequestHeader("senha") String senha,@PathVariable("id") Long id,
                                     @RequestBody Usuario body) {
        loginService.login(usuario,senha);
        return new ResponseEntity(usuarioService.alterar(body), HttpStatus.ACCEPTED);
    }
}
