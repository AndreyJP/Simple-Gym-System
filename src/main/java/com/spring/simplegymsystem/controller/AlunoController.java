package com.spring.simplegymsystem.controller;

import com.spring.simplegymsystem.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlunoController{
    
    @Autowired
    AlunoService alunoService;

    @RequestMapping(value = "/usuario/aluno/cadastrar", method = RequestMethod.GET)
    public ModelAndView getUsuarios(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/cadastrar-aluno");

        return mv;
    }
}