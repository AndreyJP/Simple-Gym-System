package com.spring.simplegymsystem.repository;

import com.spring.simplegymsystem.model.DiaSemana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Long> {

}