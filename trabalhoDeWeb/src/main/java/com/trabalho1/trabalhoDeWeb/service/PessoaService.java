package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.dto.PessoaDTO;
import com.trabalho1.trabalhoDeWeb.enums.Tipo;
import com.trabalho1.trabalhoDeWeb.repository.PessoaFisicaRepository;
import com.trabalho1.trabalhoDeWeb.repository.PessoaJuridicaRepository;
import com.trabalho1.trabalhoDeWeb.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRespository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRespository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscar(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        return pessoaOptional.orElse(null);
    }


    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    //
    public Object buscarPorId(Long id) {
        Pessoa Pessoa = pessoaRepository.findById(id).get();
        return Pessoa;
    }


    public Pessoa salvar(PessoaDTO pessoaDto) {
            if (Tipo.FISICA.equals(pessoaDto.getTipo())){
            return pessoaFisicaRespository.save(pessoaDto.gerarPessoaFisica());
        }else{
            return pessoaJuridicaRespository.save(pessoaDto.gerarPessoaJuridica());

        }
    }


    public Pessoa alterar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

}
