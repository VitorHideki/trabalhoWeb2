package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(produtoService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
        return new ResponseEntity(produtoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody Produto body) {
        return new ResponseEntity(produtoService.salvar(body), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        produtoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody Produto body) {

        return new ResponseEntity(produtoService.alterar(body), HttpStatus.ACCEPTED);
    }
}
