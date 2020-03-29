package com.spring.simplegymsystem.service;

import java.util.List;

import com.spring.simplegymsystem.model.Aluno;

public interface AlunoService {

    List<Aluno> findAll();
    Aluno findById(Long id);
    Aluno save(Aluno aluno);
    void deleteById(Long id);
}