package com.spring.simplegymsystem.service;

import java.util.List;

import com.spring.simplegymsystem.model.AulaGrupo;

public interface AulaGrupoService {

    List<AulaGrupo> findAll();
    AulaGrupo findById(Long id);
    AulaGrupo save(AulaGrupo aulaGrupo);
    void deleteById(Long id);
}