package com.spring.simplegymsystem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "aula_grupo")
public class AulaGrupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String sala;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    @NotNull
    private LocalDate horaInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    @NotNull
    private LocalDate horaFim;

    @ManyToOne
    @JoinColumn(name = "instrutor_fk")
    private Instrutor instrutor;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return this.sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public LocalDate getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDate getHoraFim() {
        return this.horaFim;
    }

    public void setHoraFim(LocalDate horaFim) {
        this.horaFim = horaFim;
    }
    
}