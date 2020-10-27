package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.dto.PessoaDTO;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;

import com.trabalho1.trabalhoDeWeb.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/pessoa")

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos(){
        return new ResponseEntity(pessoaService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id){
        return new ResponseEntity(pessoaService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id){
        pessoaService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody PessoaDTO pessoaDto) {
            return new ResponseEntity(pessoaService.salvar(pessoaDto), HttpStatus.CREATED);
        }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody Pessoa body) {

        return new ResponseEntity(pessoaService.alterar(body), HttpStatus.ACCEPTED);
    }

}
