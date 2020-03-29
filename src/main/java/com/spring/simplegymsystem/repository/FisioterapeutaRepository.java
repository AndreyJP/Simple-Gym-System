package com.spring.simplegymsystem.repository;

import com.spring.simplegymsystem.model.Fisioterapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, Long> {

}