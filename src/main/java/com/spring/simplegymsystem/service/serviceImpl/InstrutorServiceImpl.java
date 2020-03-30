package com.spring.simplegymsystem.service.serviceImpl;

import java.util.List;

import com.spring.simplegymsystem.model.Instrutor;
import com.spring.simplegymsystem.repository.InstrutorRepository;
import com.spring.simplegymsystem.service.InstrutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrutorServiceImpl implements InstrutorService {

    @Autowired
    InstrutorRepository instrutorRepository;

    @Override
    public List<Instrutor> findAll() {
        return instrutorRepository.findAll();
    }

    @Override
    public Instrutor findById(Long id) {
        return instrutorRepository.findById(id).get();
    }

    @Override
    public Instrutor save(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    @Override
    public void deleteById(Long id) {
        instrutorRepository.deleteById(id);
    }

}