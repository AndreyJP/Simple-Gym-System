package com.spring.simplegymsystem.service;

import java.util.List;

import com.spring.simplegymsystem.model.OcorrenciaAula;

public interface OcorrenciaAulaService {
    
    List<OcorrenciaAula> findAll();
    OcorrenciaAula findById(Long id);
    OcorrenciaAula save(OcorrenciaAula ocorrenciaAula);
    void deleteById(Long id);
}