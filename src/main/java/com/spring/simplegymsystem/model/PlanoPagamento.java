package com.spring.simplegymsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "plano_pagamento")
public class PlanoPagamento {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String identificacao;

    @NotNull
    private String tipo;

    @NotNull
    private int quantidadeParcelas;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(final String indentificacao) {
        this.identificacao = indentificacao;
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