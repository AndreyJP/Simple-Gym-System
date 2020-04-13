package com.spring.simplegymsystem.service.serviceImpl;

import java.util.List;

import com.spring.simplegymsystem.model.AulaGrupo;
import com.spring.simplegymsystem.repository.AulaGrupoRepository;
import com.spring.simplegymsystem.service.AulaGrupoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaGrupoServiceImpl implements AulaGrupoService {

    @Autowired
    AulaGrupoRepository aulaGrupoRepository;

    @Override
    public List<AulaGrupo> findAll() {
        return aulaGrupoRepository.findAll();
    }

    @Override
    public AulaGrupo findById(Long id) {
        return aulaGrupoRepository.findById(id).get();
    }

    @Override
    public AulaGrupo save(AulaGrupo aulaGrupo) {
        return aulaGrupoRepository.save(aulaGrupo);
    }

    @Override
    public void deleteById(Long id) {
        aulaGrupoRepository.deleteById(id);
    }

}