package com.spring.simplegymsystem.controller;

import java.time.LocalDate;
import java.util.List;

import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController{

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPaginaInicial(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/index");

        Usuario usuario = new Usuario();
        usuario.setCelular("999999");
        usuario.setCpf("999.999.999-999");
        usuario.setDataCriacao(LocalDate.now());
        usuario.setEmail("admin@email.com");
        usuario.setIdentidade("XX XX-XXX.XXX");
        usuario.setLogin("admin");
        usuario.setNome("Administrador");
        usuario.setSenha("master");
        usuario.setTelefone("(XX)X XXXX-XXXX");
        usuario.setTipo("administrador");
        usuario.setUltimoLogin(null);
        
        List<Usuario> usuarios = usuarioService.findAll();
        boolean teste = false;

        for(Usuario usuarioBanco : usuarios){
            System.out.println("USUÁRIO BANCO = " + usuarioBanco.getLogin());
            System.out.println("USUÁRIO MEMÓRIA = " + usuario.getLogin());
            if(usuarioBanco.getLogin().equals(usuario.getLogin())){
                System.out.println("VERDADEIRO");
                teste = true;
            }
        }

        System.out.println("Existe Usuário: " + teste);
        if(teste == false){
            Usuario usuarioSalvo = usuarioService.save(usuario);
            System.out.println(usuarioSalvo.getLogin());
        }

        return mv;
    }

    @RequestMapping(value = "/funcionario/login", method = RequestMethod.GET)
    public ModelAndView getLoginFuncionario(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/login-funcionario");

        
        return mv;
    }

    @RequestMapping(value = "/funcionario/login", method = RequestMethod.POST)
    public ModelAndView getLoginFuncionarioPost(){
        ModelAndView mv = new ModelAndView();
        System.out.println("POST LOGIN");
        
        mv.setViewName("html/home-funcionario");
        return mv;
    }
}