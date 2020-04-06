package com.spring.simplegymsystem.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.spring.simplegymsystem.model.PlanoPagamento;
import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.service.PlanoPagamentoService;
import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PlanoPagamentoController{
    
    @Autowired
    PlanoPagamentoService planoPagamentoService;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/plano/cadastrar", method = RequestMethod.GET)
    public ModelAndView obterCadastroDePlano(HttpSession session){
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
                mv.setViewName("html/cadastrar-plano");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/plano/cadastrar", method = RequestMethod.POST)
    public ModelAndView obterCadastroDePlanoPost(HttpSession session, WebRequest request){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                
                PlanoPagamento planoPagamento = new PlanoPagamento();
                Map<String, String[]> form = request.getParameterMap();

                planoPagamento.setIdentificacao(form.get("identificacao")[0]);
                planoPagamento.setTipo(form.get("tipoPlano")[0]);
                planoPagamento.setQuantidadeParcelas(Integer.parseInt(form.get("qtdeParcelas")[0]));

                System.out.println(planoPagamento.getIdentificacao());
                System.out.println(planoPagamento.getQuantidadeParcelas());
                System.out.println(planoPagamento.getTipo());

                planoPagamentoService.save(planoPagamento);

                mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/plano/cadastrar");
            }else{
                mv.setViewName("redirect:/plano/cadastrar");
            }
        }else{
            mv.setViewName("redirect:/plano/cadastrar");
        }

        return mv;
    }
}