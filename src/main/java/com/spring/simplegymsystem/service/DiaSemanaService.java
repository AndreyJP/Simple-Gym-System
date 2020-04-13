package com.spring.simplegymsystem.service;

import java.util.List;

import com.spring.simplegymsystem.model.DiaSemana;

public interface DiaSemanaService {
    
    List<DiaSemana> findAll();
    DiaSemana findById(Long id);
    DiaSemana save(DiaSemana diaSemana);
    void deleteById(Long id);
}