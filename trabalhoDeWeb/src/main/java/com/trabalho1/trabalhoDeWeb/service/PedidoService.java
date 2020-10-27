package com.trabalho1.trabalhoDeWeb.service;


import com.trabalho1.trabalhoDeWeb.entity.Pedido;
import com.trabalho1.trabalhoDeWeb.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;



    public Pedido buscar(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        return pedidoOptional.orElse(null);
    }


    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }


    public Object buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }


    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }


    public Pedido alterar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
