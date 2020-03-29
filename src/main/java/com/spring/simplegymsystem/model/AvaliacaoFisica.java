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
@Table(name = "avaliacao_fisica")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate dataAvaliacao;

    @NotNull
    private String parecer;

    @ManyToOne
    @JoinColumn(name = "aluno_fk")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "fisioterapeuta_fk")
    private Fisioterapeuta fisioterapeuta;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAvaliacao() {
        return this.dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getParecer() {
        return this.parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

}