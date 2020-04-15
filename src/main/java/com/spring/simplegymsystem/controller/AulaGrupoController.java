package com.spring.simplegymsystem.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.spring.simplegymsystem.model.AulaGrupo;
import com.spring.simplegymsystem.model.DiaSemana;
import com.spring.simplegymsystem.model.Instrutor;
import com.spring.simplegymsystem.model.OcorrenciaAula;
import com.spring.simplegymsystem.model.Usuario;
import com.spring.simplegymsystem.service.AulaGrupoService;
import com.spring.simplegymsystem.service.DiaSemanaService;
import com.spring.simplegymsystem.service.InstrutorService;
import com.spring.simplegymsystem.service.OcorrenciaAulaService;
import com.spring.simplegymsystem.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AulaGrupoController {

    @Autowired
    AulaGrupoService aulaGrupoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InstrutorService instrutorService;

    @Autowired
    DiaSemanaService diaSemanaService;

    @Autowired
    OcorrenciaAulaService ocorrenciaAulaService;

    @RequestMapping(value = "/aula-grupo", method = RequestMethod.GET)
    public ModelAndView obterAulas(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista") || usuario.getTipo().equals("instrutor")){

                List<OcorrenciaAula> ocorrenciaAulas = ocorrenciaAulaService.findAll();
                List<AulaGrupo> aulasGrupo = aulaGrupoService.findAll();

                mv.addObject("aulas", aulasGrupo);
                mv.addObject("ocorrencias", ocorrenciaAulas);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/lista-aulas");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/aula-grupo/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrarAulas(HttpSession session){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                
                List<Instrutor> instrutores = instrutorService.findAll();
                List<DiaSemana> diasSemana = diaSemanaService.findAll();

                mv.addObject("instrutores", instrutores);
                mv.addObject("diasSemana", diasSemana);
                mv.addObject("usuario", usuario);
                mv.setViewName("html/cadastrar-aula");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/aula-grupo/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrarAulasPost(HttpSession session, WebRequest request){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                
                Map<String, String[]> form = request.getParameterMap();

                AulaGrupo aulaGrupo = new AulaGrupo();

                Instrutor instrutor = new Instrutor();
                instrutor = instrutorService.findById(Long.parseLong(form.get("instrutor")[0]));

                DiaSemana diaSemana = new DiaSemana();

                aulaGrupo.setNome(form.get("nome")[0]);
                aulaGrupo.setSala(form.get("sala")[0]);
                aulaGrupo.setHoraInicio(LocalTime.parse(form.get("hora-inicio")[0]));
                aulaGrupo.setHoraFim(LocalTime.parse(form.get("hora-fim")[0]));
                aulaGrupo.setInstrutor(instrutor);

                AulaGrupo aulaGrupoCriada = aulaGrupoService.save(aulaGrupo);
                List<DiaSemana> diasSemana = new ArrayList<>();

                for(int i = 0; i < form.get("diaSemana").length; i++){
                    diaSemana = diaSemanaService.findById(Long.parseLong(form.get("diaSemana")[i]));
                    diasSemana.add(diaSemana);
                }

                for(DiaSemana dia : diasSemana){
                    OcorrenciaAula ocorrenciaAula = new OcorrenciaAula();
                    System.out.println(dia.getNome());
                    ocorrenciaAula.setAulaGrupo(aulaGrupoCriada);
                    ocorrenciaAula.setDiaSemana(dia);
                    ocorrenciaAulaService.save(ocorrenciaAula);
                }
                
                //mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/aula-grupo");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }

    @RequestMapping(value = "/aula-grupo/{idAula}/deletar", method = RequestMethod.GET)
    public ModelAndView deletarAluno(HttpSession session, @PathVariable Long idAula){
        ModelAndView mv = new ModelAndView();

        Long id = (Long) session.getAttribute("idUsuario");
        Usuario usuario = null;

        if(id != null){
            usuario = usuarioService.findById(id);
        }
        
        if(usuario != null){
            if(usuario.getTipo().equals("administrador") || usuario.getTipo().equals("recepcionista")){
                AulaGrupo aulaGrupo = aulaGrupoService.findById(idAula);
                List<OcorrenciaAula> ocorrenciaAulas = ocorrenciaAulaService.findAll();

                for(OcorrenciaAula ocorrenciaAula : ocorrenciaAulas){
                    if(ocorrenciaAula.getAulaGrupo().getId().equals(aulaGrupo.getId())){
                        ocorrenciaAulaService.deleteById(ocorrenciaAula.getId());
                    }
                }

                System.out.println(idAula);

                aulaGrupoService.deleteById(idAula);

                // mv.addObject("alunos", alunos);
                // mv.addObject("usuario", usuario);
                mv.setViewName("redirect:/aula-grupo");
            }else{
                mv.setViewName("redirect:/usuario/funcionario");
            }
        }else{
            mv.setViewName("redirect:/usuario/funcionario");
        }

        return mv;
    }
}