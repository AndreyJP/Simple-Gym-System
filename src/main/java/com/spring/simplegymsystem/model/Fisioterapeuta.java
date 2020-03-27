package com.spring.simplegymsystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "fisioterapeuta")
public class Fisioterapeuta implements Serializable{

     /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @OneToOne
    @Id
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;
    
    @NotBlank
    private String registro;

    public String getRegistro() {
        return this.registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

}