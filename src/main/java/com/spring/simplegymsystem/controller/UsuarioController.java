package com.spring.simplegymsystem.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.spring.simplegymsystem.model.Instrutor;
import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.service.InstrutorService;
import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UsuarioController{
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InstrutorService instrutorService;

    @RequestMapping(value = "/usuario/funcionario", method = RequestMethod.GET)
    public ModelAndView getPaginaInicialFuncionario(HttpSession session){
        ModelAndView mv = new ModelAndView("");

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista") || usuario.getTipo().equals("fisioterapeuta") || usuario.getTipo().equals("instrutor")){
                usuario = usuarioService.findById(id);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/home-funcionario");
            }else{
                mv.setViewName("redirect:/login");
            }
        }else{
            mv.setViewName("redirect:/login");
        }

        return mv;
    }

    @RequestMapping(value = "/usuario/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadstrarUsuario(HttpSession session){
        ModelAndView mv = new ModelAndView("");

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador")){
                usuario = usuarioService.findById(id);
            mv.addObject("usuario", usuario);
            mv.setViewName("html/cadastrar-usuario");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/usuario/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadstrarUsuarioPost(HttpSession session, WebRequest request){
        ModelAndView mv = new ModelAndView("");

        System.out.println("Post Usuário");
        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador")){
                usuario = usuarioService.findById(id);
                Usuario usuarioCriado = new Usuario();
                Map<String, String[]> form = request.getParameterMap();

                usuarioCriado.setTipo(form.get("tipo")[0]);
                usuarioCriado.setNome(form.get("nome")[0]);
                usuarioCriado.setCpf(form.get("cpf")[0]);
                usuarioCriado.setIdentidade(form.get("identidade")[0]);
                usuarioCriado.setEmail(form.get("email")[0]);
                usuarioCriado.setTelefone(form.get("telefone")[0]);
                usuarioCriado.setCelular(form.get("celular")[0]);
                usuarioCriado.setLogin(form.get("login")[0]);
                usuarioCriado.setSenha(form.get("senha")[0]);
                usuarioCriado.setDataCriacao(LocalDate.now());
                usuarioCriado.setUltimoLogin(null);

                usuarioService.save(usuarioCriado);
                
                mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/usuario/cadastrar");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        if(usuario.getTipo().equals("administrador")){
            
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/usuario/instrutor", method = RequestMethod.GET)
    public ModelAndView obterInstrutores(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                List<Instrutor> instrutores = new ArrayList<>();
                instrutores = instrutorService.findAll();

                mv.addObject("instrutores", instrutores);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/lista-instrutores");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/instrutor/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadstrarInstrutor(HttpSession session){
        ModelAndView mv = new ModelAndView("");

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/cadastrar-instrutor");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/instrutor/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadstrarInstrutorPost(HttpSession session, WebRequest request){
        ModelAndView mv = new ModelAndView("");

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                Usuario usuarioCriado = new Usuario();
                Map<String, String[]> form = request.getParameterMap();

                usuarioCriado.setTipo("instrutor");
                usuarioCriado.setNome(form.get("nome")[0]);
                usuarioCriado.setCpf(form.get("cpf")[0]);
                usuarioCriado.setIdentidade(form.get("identidade")[0]);
                usuarioCriado.setEmail(form.get("email")[0]);
                usuarioCriado.setTelefone(form.get("telefone")[0]);
                usuarioCriado.setCelular(form.get("celular")[0]);
                usuarioCriado.setLogin(form.get("login")[0]);
                usuarioCriado.setSenha(form.get("senha")[0]);
                usuarioCriado.setDataCriacao(LocalDate.now());
                usuarioCriado.setUltimoLogin(null);

                Usuario usuarioInstrutor = usuarioService.save(usuarioCriado);
                
                Instrutor instrutor = new Instrutor();
                instrutor.setUsuario(usuarioInstrutor);
                instrutor.setTipoAula(form.get("tipoAula")[0]);
                instrutor.setFormacao(form.get("formacao")[0]);

                instrutorService.save(instrutor);
                
                mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/usuario/instrutor");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/instrutor/{idInstrutor}/deletar", method = RequestMethod.GET)
    public ModelAndView deletarInstrutor(HttpSession session, @PathVariable Long idInstrutor){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                
                System.out.println(idInstrutor);

                usuarioService.deleteById(idInstrutor);

                // mv.addObject("alunos", alunos);
                // mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/usuario/instrutor");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }
}