package com.spring.simplegymsystem.service;

import java.util.List;

import com.spring.simplegymsystem.model.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);

}