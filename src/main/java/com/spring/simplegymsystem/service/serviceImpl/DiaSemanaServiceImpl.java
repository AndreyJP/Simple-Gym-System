package com.spring.simplegymsystem.service.serviceImpl;

import java.util.List;

import com.spring.simplegymsystem.model.DiaSemana;
import com.spring.simplegymsystem.repository.DiaSemanaRepository;
import com.spring.simplegymsystem.service.DiaSemanaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaSemanaServiceImpl implements DiaSemanaService {

    @Autowired
    DiaSemanaRepository diaSemanaRepository;

    @Override
    public List<DiaSemana> findAll() {
        return diaSemanaRepository.findAll();
    }

    @Override
    public DiaSemana findById(Long id) {
        return diaSemanaRepository.findById(id).get();
    }

    @Override
    public DiaSemana save(DiaSemana diaSemana) {
        return diaSemanaRepository.save(diaSemana);
    }

    @Override
    public void deleteById(Long id) {
        diaSemanaRepository.deleteById(id);
    }

}