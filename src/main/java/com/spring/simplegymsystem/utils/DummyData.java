package com.spring.simplegymsystem.utils;

import java.time.LocalDate;

import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DummyData {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    //@PostConstruct
    public void saveUser() {
        Usuario usuario = new Usuario();
        usuario.setCelular("998282108");
        usuario.setCpf("111.144.888-25");
        usuario.setDataCriacao(LocalDate.now());
        usuario.setEmail("teste@email.com");
        usuario.setIdentidade("MG 44.789.569");
        usuario.setLogin("usuario1");
        usuario.setNome("Teste");
        usuario.setSenha("123456");
        usuario.setTelefone("(35)3698-7456");
        usuario.setTipo("gerente");
        usuario.setUltimoLogin(LocalDate.now());

        System.out.println("CHEGUEI ATÉ AQUI");
        System.out.println(usuario.getCelular());
        System.out.println(usuario.getCpf());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getIdentidade());
        System.out.println(usuario.getLogin());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getSenha());
        System.out.println(usuario.getTelefone());
        System.out.println(usuario.getTipo());
        System.out.println(usuario.getDataCriacao());
        System.out.println(usuario.getUltimoLogin());

        
        usuarioRepository.save(usuario);

        //usuario = ServiceLocator.getUsuarioService().findById(Long.parseLong("1"));
        //System.out.println("USUÁRIO LIDO " + usuario.getNome());
    }
}