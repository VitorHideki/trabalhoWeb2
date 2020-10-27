package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(Usuario cliente) {
        Pessoa aux;
        
        return produtoRepository.findAll();
    }

    public Object buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto alterar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

}