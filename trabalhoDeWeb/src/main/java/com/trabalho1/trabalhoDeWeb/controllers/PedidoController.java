package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.entity.Pedido;

import com.trabalho1.trabalhoDeWeb.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos(){
        return new ResponseEntity(pedidoService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id){
        return new ResponseEntity(pedidoService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id){
        pedidoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody Pedido pedido) {
        return new ResponseEntity(pedidoService.salvar(pedido), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody Pedido body) {

        return new ResponseEntity(pedidoService.alterar(body), HttpStatus.ACCEPTED);
    }

}
