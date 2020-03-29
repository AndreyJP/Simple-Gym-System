package com.spring.simplegymsystem.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fisioterapeuta")
public class Fisioterapeuta{

    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;
    
    @NotNull
    private String registro;

    public String getRegistro() {
        return this.registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

}