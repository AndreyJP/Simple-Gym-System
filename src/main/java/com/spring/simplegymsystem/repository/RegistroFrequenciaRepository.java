package com.spring.simplegymsystem.repository;

import com.spring.simplegymsystem.model.RegistroFrequencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroFrequenciaRepository extends JpaRepository<RegistroFrequencia, Long> {

}