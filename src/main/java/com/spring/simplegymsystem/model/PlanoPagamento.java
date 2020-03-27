package com.spring.simplegymsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "plano_pagamento")
public class PlanoPagamento {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String indentificacao;

    @NotBlank
    private String tipo;

    @NotBlank
    private int quantidadeParcelas;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getIndentificacao() {
        return this.indentificacao;
    }

    public void setIndentificacao(final String indentificacao) {
        this.indentificacao = indentificacao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeParcelas() {
        return this.quantidadeParcelas;
    }

    public void setQuantidadeParcelas(final int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

}