package com.spring.simplegymsystem.controller;

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

    @RequestMapping(value = "/usuario/aluno/cadastrar", method = RequestMethod.GET)
    public ModelAndView obterCadastroAluno(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Usuario usuario = null;
        Long id = (Long) session.getAttribute("idAdmin");

        if(id != null){
            usuario = usuarioService.findById(id);
            mv.addObject("usuario", usuario);
            mv.setViewName("html/cadastrar-aluno");
        }else{
            id = (Long) session.getAttribute("idRecep");
            if(id != null){
                usuario = usuarioService.findById(id);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/cadastrar-aluno");
            }else{
                mv.setViewName("redirect:/");
            }
        }
        
        return mv;
    }
}