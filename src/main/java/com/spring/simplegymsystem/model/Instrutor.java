package com.spring.simplegymsystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instrutor")
public class Instrutor implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @OneToOne
    @Id
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;
    
    @NotBlank
    private String tipoAula;

    @NotBlank
    private String formacao;

    public String getTipoAula() {
        return this.tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public String getFormacao() {
        return this.formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

}