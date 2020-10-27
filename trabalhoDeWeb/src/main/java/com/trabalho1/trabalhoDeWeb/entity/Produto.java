package com.trabalho1.trabalhoDeWeb.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "TB_PRODUTO")
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Produto {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PROD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "PROD_DESCRICAO", nullable = true)
    private String idResponsavel;

    @Column(name = "PROD_QUANTIDADEESTOQUE")
    private Long qtdEstoque;


    @Column(name = "PROD_IDADEPERMITIDA")
    private int idadePermimitda;

    @Column(name = "PROD_PRECOCOMPRA")
    private double precoCompra;

    @Column(name = "PROD_PRECOVENDAFISICA")
    private double precoVendaFisica;

    @Column(name = "PROD_PRECOVENDAJURIDICA")
    private double precoVendaJuridica;


    public Produto(Long id){
        this.id = id;
    }

    public Produto() {

    }
}
