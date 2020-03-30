package com.spring.simplegymsystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController{

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPaginaInicial(HttpSession session){
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
            // System.out.println("USUÁRIO BANCO = " + usuarioBanco.getLogin());
            // System.out.println("USUÁRIO MEMÓRIA = " + usuario.getLogin());
            if(usuarioBanco.getLogin().equals(usuario.getLogin())){
                // System.out.println("VERDADEIRO");
                teste = true;
            }
        }

        // System.out.println("Existe Usuário: " + teste);
        if(teste == false){
            Usuario usuarioSalvo = usuarioService.save(usuario);
            System.out.println(usuarioSalvo.getLogin());
        }

        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginFuncionario(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/login");

        
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLoginFuncionarioPost(HttpSession session, WebRequest request){
        ModelAndView mv = new ModelAndView("");
        System.out.println("POST LOGIN");

        Map<String, String[]> form = request.getParameterMap();
        String login = form.get("usuario")[0];
        String senha = form.get("senha")[0];

        Usuario usuario = new Usuario();

        List<Usuario> usuarios = usuarioService.findAll();
        for(Usuario usuarioSalvo : usuarios){
            System.out.println(usuarioSalvo.getLogin());
            System.out.println(usuarioSalvo.getSenha());
            System.out.println(login + " " + senha);
            if(usuarioSalvo.getLogin().equals(login) && usuarioSalvo.getSenha().equals(senha)){
                //System.out.println("USUÁRIO EXISTE!!!");
                usuario = usuarioSalvo;
            }
        }

        String tipoUsuario = usuario.getTipo();

        if(tipoUsuario != null){
            switch(tipoUsuario){
                case "administrador":
                    System.out.println("ADMIN");
                    session.setAttribute("idUsuario", usuario.getId());
                    usuario.setUltimoLogin(LocalDate.now());
                    usuarioService.save(usuario);
                    mv.setViewName("redirect:/usuario/funcionario");
                break;
                case "recepcionista":
                    System.out.println("RECEPCIONISTA");
                    session.setAttribute("idUsuario", usuario.getId());
                    usuario.setUltimoLogin(LocalDate.now());
                    usuarioService.save(usuario);
                    mv.setViewName("redirect:/usuario/funcionario");
                break;
                case "instrutor":
                    System.out.println("INSTRUTOR");
                    session.setAttribute("idUsuario", usuario.getId());
                    usuario.setUltimoLogin(LocalDate.now());
                    usuarioService.save(usuario);
                    mv.setViewName("redirect:/usuario/funcionario");
                break;
            }
        }else{
            System.out.println("EXECUTANDO DEFAULT");
            mv.setViewName("redirect:/login");
        }

        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutUsuario(HttpSession session){
        ModelAndView mv = new ModelAndView("redirect:/");
        session.removeAttribute("idUsuario");
        return mv;
    }
}