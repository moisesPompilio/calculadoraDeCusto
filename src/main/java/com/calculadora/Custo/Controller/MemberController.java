package com.calculadora.Custo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.Custo.Model.Member;
import com.calculadora.Custo.Reposiory.FuncionarioRepository;
import com.calculadora.Custo.Reposiory.MemberRepository;
import com.calculadora.Custo.Reposiory.ProjectsRepository;

@RestController
@CrossOrigin
@RequestMapping("/Member")
public class MemberController {
    @Autowired
    private MemberRepository repository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ProjectsRepository projectsRepository;

    @GetMapping("/Listar")
    public @ResponseBody List<Member> listarMember() {
        return repository.findAll();
    }

    @DeleteMapping("/Deletar")
    public @ResponseBody Object deletar(@RequestBody Member project) {
        try {
            repository.delete(project);
            return project;
        } catch (Exception e) {
            return e;
        }
    }

    @PostMapping("/Salvar")
    public @ResponseBody Object salvarMember(@RequestBody Member member) {
        try {
            if (funcionarioRepository.findById(member.getFuncionario()) == null) {
                return "Funcionario nao existe";
            } else if (projectsRepository.findById(member.getProjects()) == null) {
                return "Projeto nao existe";
            } else {
                List<Member> list = repository.findByProjects(member.getProjects());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getFuncionario() == member.getFuncionario()) {
                        return "Member existente, nome: " + member.getFuncionario();
                    }
                }
                return repository.save(member);
            }

            // return repository.save(project);
        } catch (Exception e) {
            return e;
        }

    }

    @PutMapping("/alterar")
    public @ResponseBody Object alterarMember(@RequestBody Member member) {
        try {
            if (repository.findById(member.getId()) == null) {
                return "Member nao encontrado, nome: " + member.getId();
            } else {
                if (funcionarioRepository.findById(member.getFuncionario()) == null) {
                    return "Funcionario nao existe";
                } else if (projectsRepository.findById(member.getProjects()) == null) {
                    return "Projeto nao existe";
                } else {
                    return repository.save(member);
                }

            }
        } catch (Exception e) {
            return e;
        }
    }

    @GetMapping("/ListarProject")
    public @ResponseBody List<Object> listarMemberOfProject(@RequestBody Member member) {
        List<Object> lista = new ArrayList<Object>();
        try {
            List<Member> list = repository.findByProjects(member.getProjects());
            if (list == null) {
                lista.add("Nao ninguem cadatrado nesse projeto");
                return lista;
            } else {
                lista.add(list);
                return lista;
            }
        } catch (Exception e) {
            lista.add(e);
            return lista;
        }
    }

    @GetMapping("/ListarFuncionario")
    public @ResponseBody List<Object> listarMemberOfFuncionario(@RequestBody Member member) {
        List<Object> lista = new ArrayList<Object>();
        try {
            List<Member> list = repository.findByFuncionario(member.getProjects());
            if (list == null) {
                lista.add("Nao ninguem cadatrado nesse projeto");
                return lista;
            } else {
                lista.add(list);
                return lista;
            }
        } catch (Exception e) {
            lista.add(e);
            return lista;
        }
    }

}
