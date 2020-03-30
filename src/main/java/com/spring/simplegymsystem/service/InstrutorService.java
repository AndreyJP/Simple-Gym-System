package com.spring.simplegymsystem.service;

import java.util.List;

import com.spring.simplegymsystem.model.Instrutor;

public interface InstrutorService {

    List<Instrutor> findAll();
    Instrutor findById(Long id);
    Instrutor save(Instrutor instrutor);
    void deleteById(Long id);
}