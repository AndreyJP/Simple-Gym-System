package com.spring.simplegymsystem.service;

import java.util.List;

import com.spring.simplegymsystem.model.PlanoPagamento;

public interface PlanoPagamentoService {

    List<PlanoPagamento> findAll();
    PlanoPagamento findById(Long id);
    PlanoPagamento save(PlanoPagamento planoPagamento);
    void deleteById(Long id);
}