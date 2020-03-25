package com.spring.simplegymsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPáginaInicial(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/index");
        return mv;
    }
}