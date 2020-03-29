package com.spring.simplegymsystem.repository;

import com.spring.simplegymsystem.model.AulaGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaGrupoRepository extends JpaRepository<AulaGrupo, Long> {

}