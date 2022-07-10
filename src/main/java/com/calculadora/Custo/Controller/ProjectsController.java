package com.calculadora.Custo.Controller;

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

import com.calculadora.Custo.Model.Projects;
import com.calculadora.Custo.Reposiory.ProjectsRepository;

@RestController
@CrossOrigin
@RequestMapping("/Projects")
public class ProjectsController {
    @Autowired
    private ProjectsRepository repository;

    @GetMapping("/Listar")
    public @ResponseBody List<Projects> listarProjects() {
        return repository.findAll();
    }

    @PostMapping("/ProcurarPorName")
    public @ResponseBody Object procurarPorName(@RequestBody Projects name) {
        try {
            Projects projects = repository.findByName(name.getName());
            if (projects == null) {
                return "projeto nao existe";
            } else {
                return projects;
            }
        } catch (Exception e) {
            return e;
        }

    }

    @PostMapping("/Salvar")
    public @ResponseBody Object salvarProject(@RequestBody Projects project) {
        try {
            if (repository.findByName(project.getName()) != null) {
                return "Project existente, nome: " + project.getName();
            } else {
                return repository.save(project);
            }
            //return repository.save(project);
        } catch (Exception e) {
            return e;
        }

    }
    @PutMapping("/alterar")
    public @ResponseBody Object alterarPrject(@RequestBody Projects project) {
        try {
            if (repository.findByName(project.getName()) == null) {
                return "Project nao encontrado, nome: " + project.getName();
            } else {
                return repository.save(project);
            }
        } catch (Exception e) {
            return e;
        }

    }
    @PutMapping("/adicionarMembro")
    public @ResponseBody Object adicionarMembro(@RequestBody Projects project) {
        try {
            Projects projeto = repository.findById(project.getId());
            Projects projetoAntigo = projeto;
            if (repository.findByName(project.getName()) == null) {
                return "Project nao encontrado, nome: " + project.getName();
            } else {
                projeto.adicionarMembers(project.getMembers());
                return "dados antigo: " + projetoAntigo + "dados novos" + repository.save(projeto);
            }
        } catch (Exception e) {
            return e;
        }

    }

    @PutMapping("/adicionaExpenses")
    public @ResponseBody Object adicionaExpenses(@RequestBody Projects project) {
        try {
            Projects projeto = repository.findById(project.getId());
            Projects projetoAntigo = projeto;
            if (repository.findByName(project.getName()) == null) {
                return "Project nao encontrado, nome: " + project.getName();
            } else {
                if(projeto.getClosed()){
                    projeto.setProjectSpentMaintenance(project.getHoursSpentTotal(), project.getSpentTotal());
                }else{
                    projeto.setProjectSpentCreation(project.getHoursSpentTotal(), project.getSpentTotal());
                }
                return "dados antigo: " + projetoAntigo + "dados novos" + repository.save(projeto);
            }
        } catch (Exception e) {
            return e;
        }

    }
    @DeleteMapping("/Deletar")
    public @ResponseBody Object deletar(@RequestBody Projects project){
        try {
            repository.delete(project);
        return project;
        } catch (Exception e) {
            return e;
        }
    }
}
