package com.spring.simplegymsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.service.AlunoService;
import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlunoController{
    
    @Autowired
    AlunoService alunoService;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario/aluno", method = RequestMethod.GET)
    public ModelAndView obterAlunos(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                List<Usuario> usuarios = new ArrayList<>();
                usuarios = usuarioService.findAll();

                mv.addObject("usuarios", usuarios);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/lista-alunos");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/usuario/aluno/cadastrar", method = RequestMethod.GET)
    public ModelAndView obterCadastroAluno(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/cadastrar-aluno");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }
}