package com.spring.simplegymsystem.service.serviceImpl;

import java.util.List;

import com.spring.simplegymsystem.model.PlanoPagamento;
import com.spring.simplegymsystem.repository.PlanoPagamentoRepository;
import com.spring.simplegymsystem.service.PlanoPagamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoPagamentoServiceImpl implements PlanoPagamentoService {

    @Autowired
    PlanoPagamentoRepository planoPagamentoRepository;

    @Override
    public List<PlanoPagamento> findAll() {
        return planoPagamentoRepository.findAll();
    }

    @Override
    public PlanoPagamento findById(Long id) {
        return planoPagamentoRepository.findById(id).get();
    }

    @Override
    public PlanoPagamento save(PlanoPagamento planoPagamento) {
        return planoPagamentoRepository.save(planoPagamento);
    }

    @Override
    public void deleteById(Long id) {
        planoPagamentoRepository.deleteById(id);
    }

}