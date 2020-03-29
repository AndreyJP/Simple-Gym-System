package com.spring.simplegymsystem.repository;

import com.spring.simplegymsystem.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

}