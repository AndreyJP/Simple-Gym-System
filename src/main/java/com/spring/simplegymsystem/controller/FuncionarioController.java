package com.spring.simplegymsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FuncionarioController{
    
    /*@Autowired
    FuncionarioService funcionarioService;*/

    @RequestMapping(value = "/usuario/funcionario", method = RequestMethod.GET)
    public ModelAndView getPaginaInicialFuncionario(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/home-funcionario");

        return mv;
    }
}