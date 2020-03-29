package com.spring.simplegymsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ocorrencia_aula")
public class OcorrenciaAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dia_semana_fk")
    private DiaSemana diaSemana;

    @ManyToOne
    @JoinColumn(name = "aula_grupo_fk")
    private AulaGrupo aulaGrupo;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}