package com.calculadora.Custo.Controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.Custo.Model.Expenses;
import com.calculadora.Custo.Model.Funcionarios;
import com.calculadora.Custo.Model.Member;
import com.calculadora.Custo.Model.Projects;
import com.calculadora.Custo.Model.RecordTimeLog;
import com.calculadora.Custo.Reposiory.ExpensesRepository;
import com.calculadora.Custo.Reposiory.FuncionarioRepository;
import com.calculadora.Custo.Reposiory.ProjectsRepository;

@RestController
@CrossOrigin
@RequestMapping("/Expenses")
public class ExpensesController {
    @Autowired
    private ExpensesRepository repository;
    @Autowired
    private RecordTimeLogConroller recordTimeLogConroller;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ProjectsRepository projectsRepository;
    @Autowired
    private ProjectsController projectsController;

    @GetMapping("/Listar")
    public @ResponseBody List<Expenses> listarFuncionarios() {
        return repository.findAll();
    }

    @PostMapping("/Salvar")
    public @ResponseBody Object salvar(@RequestBody Member member) {
        try {
            Expenses dispesa = new Expenses();
            List<RecordTimeLog> ponto = recordTimeLogConroller.salvar(member);
            if (ponto.size() == 2) {
                int[] entradaSaida = { ponto.get(0).getId(), ponto.get(1).getId() };
                dispesa.setEntradaSaida(entradaSaida);
                dispesa.setMeber(member);
                Date entrada = ponto.get(0).getDate();
                Date saida = ponto.get(1).getDate();
                Long diff = saida.getTime() - entrada.getTime();
                TimeUnit time = TimeUnit.SECONDS;
                float tempoSeconds = time.convert(diff, TimeUnit.MILLISECONDS);
                time = TimeUnit.HOURS;
                float hour = time.convert(diff, TimeUnit.MILLISECONDS);
                Funcionarios funcionario = funcionarioRepository.findById(member.getFuncionario());
                System.out.println(funcionario);
                float value = (funcionario.getValueHours() / 3600) * tempoSeconds;
                System.out.println("value " + value);
                dispesa.setHour(hour);
                dispesa.setValue(value);
                Projects projects = projectsRepository.findById(member.getProjects());
                projects.setHoursSpentTotal(hour);
                projects.setSpentTotal(value);
                dispesa.setMaintenance(projects.getClosed());
                projectsController.adicionaExpenses(projects);
                return repository.save(dispesa);
            } else {
                return ponto;
            }
        } catch (Exception e) {
            return e;
        }
    }
}
