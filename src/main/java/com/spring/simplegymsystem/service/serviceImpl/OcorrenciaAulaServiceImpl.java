package com.spring.simplegymsystem.service.serviceImpl;

import java.util.List;

import com.spring.simplegymsystem.model.OcorrenciaAula;
import com.spring.simplegymsystem.repository.OcorrenciaAulaRepository;
import com.spring.simplegymsystem.service.OcorrenciaAulaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaAulaServiceImpl implements OcorrenciaAulaService {

    @Autowired
    OcorrenciaAulaRepository ocorrenciaAulaRepository;

    @Override
    public List<OcorrenciaAula> findAll() {
        return ocorrenciaAulaRepository.findAll();
    }

    @Override
    public OcorrenciaAula findById(Long id) {
        return ocorrenciaAulaRepository.findById(id).get();
    }

    @Override
    public OcorrenciaAula save(OcorrenciaAula ocorrenciaAula) {
        return ocorrenciaAulaRepository.save(ocorrenciaAula);
    }

    @Override
    public void deleteById(Long id) {
        ocorrenciaAulaRepository.deleteById(id);
    }

}