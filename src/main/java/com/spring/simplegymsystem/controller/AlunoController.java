package com.spring.simplegymsystem.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.spring.simplegymsystem.model.Aluno;
import com.spring.simplegymsystem.model.PlanoPagamento;
import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.service.AlunoService;
import com.spring.simplegymsystem.service.PlanoPagamentoService;
import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlunoController{
    
    @Autowired
    AlunoService alunoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PlanoPagamentoService planoPagamentoService;

    @RequestMapping(value = "/usuario/aluno", method = RequestMethod.GET)
    public ModelAndView obterAlunos(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista") || usuario.getTipo().equals("instrutor") || usuario.getTipo().equals("fisioterapeuta")){
                usuario = usuarioService.findById(id);
                List<Aluno> alunos = new ArrayList<>();
                alunos = alunoService.findAll();

                mv.addObject("alunos", alunos);
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
                List<PlanoPagamento> planosPagamento = planoPagamentoService.findAll();

                mv.addObject("planos", planosPagamento);
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

    @RequestMapping(value = "/usuario/aluno/cadastrar", method = RequestMethod.POST)
    public ModelAndView obterCadastroAlunoPost(HttpSession session, WebRequest request){
        ModelAndView mv = new ModelAndView();

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

                usuarioCriado.setTipo("aluno");
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

                Long idPlano = Long.parseLong(form.get("planopgto")[0]);
                
                PlanoPagamento planoPagamento = planoPagamentoService.findById(idPlano);

                Aluno aluno = new Aluno();

                aluno.setBairro(form.get("bairro")[0]);
                aluno.setRua(form.get("rua")[0]);
                aluno.setEstado(form.get("uf")[0]);
                aluno.setCidade(form.get("cidade")[0]);
                aluno.setUsuario(usuarioCriado);
                aluno.setPlanoPagamento(planoPagamento);

                System.out.println(aluno.getUsuario().getNome());
                System.out.println(aluno.getPlanoPagamento().getIdentificacao());

                usuarioService.save(usuarioCriado);
                alunoService.save(aluno);
                
                mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/usuario/aluno");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/usuario/aluno/{idAluno}/deletar", method = RequestMethod.GET)
    public ModelAndView deletarAluno(HttpSession session, @PathVariable Long idAluno){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                usuario = usuarioService.findById(id);
                
                System.out.println(idAluno);

                usuarioService.deleteById(idAluno);
                //alunoService.deleteById(idAluno);

                // mv.addObject("alunos", alunos);
                // mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/usuario/aluno");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/usuario/aluno/home", method = RequestMethod.GET)
    public ModelAndView acessarHomeAluno(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("aluno")){
                usuario = usuarioService.findById(id);

                mv.addObject("usuario", usuario);
                mv.setViewName("html/home-aluno");
            }else{
                mv.setViewName("redirect:/login");
            }
        }else{
            mv.setViewName("redirect:/login");
        }

        return mv;
    }
}