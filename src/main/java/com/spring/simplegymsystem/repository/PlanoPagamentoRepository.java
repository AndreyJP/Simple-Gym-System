package com.spring.simplegymsystem.repository;

import com.spring.simplegymsystem.model.PlanoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoPagamentoRepository extends JpaRepository<PlanoPagamento, Long> {

}