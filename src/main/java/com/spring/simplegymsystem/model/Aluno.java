package com.spring.simplegymsystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @OneToOne
    @Id
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;
    
    // @NotBlank
    // @Column(unique=true)
    // private String matricula;

    @NotBlank
    private String rua;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @ManyToOne
    @JoinColumn(name = "plano_fk")
    private PlanoPagamento planoPagamento;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Matricula matricula;

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}