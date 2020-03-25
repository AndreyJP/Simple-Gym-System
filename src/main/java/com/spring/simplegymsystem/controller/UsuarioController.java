package com.spring.simplegymsystem.controller;

import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.spring.simplegymsystem.model.Usuario;


@Controller
public class UsuarioController{
    
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ModelAndView getUsuarios(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/usuarios");
        final List<Usuario> usuarios = usuarioService.findAll();
        mv.addObject("usuarios", usuarios);

        for(Usuario usuario : usuarios){
            System.out.println("TERMINANDO O GET");
            System.out.println(usuario.getNome());
        }

        return mv;
    }
}