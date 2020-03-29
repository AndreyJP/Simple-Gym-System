package com.spring.simplegymsystem.service.serviceImpl;

import java.util.List;

import com.spring.simplegymsystem.model.Aluno;
import com.spring.simplegymsystem.repository.AlunoRepository;
import com.spring.simplegymsystem.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno findById(Long id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

}