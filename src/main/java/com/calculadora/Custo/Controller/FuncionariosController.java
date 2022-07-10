package com.calculadora.Custo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.Custo.Model.Funcionarios;
import com.calculadora.Custo.Reposiory.FuncionarioRepository;

@RestController
@CrossOrigin
@RequestMapping("/Funcionarios")
public class FuncionariosController {
    @Autowired
    private FuncionarioRepository repository;

    // private final PasswordEncoder encoder;
    
    // public FuncionariosController(FuncionarioRepository repository, PasswordEncoder encoder) {
    //     this.repository = repository;
    //     this.encoder = encoder;
    // }

    @GetMapping("/Listar")
	public @ResponseBody List<Funcionarios> listarFuncionarios() {
		return repository.findAll();
	}
	
	@PostMapping("/ProcurarPorName")
	public @ResponseBody Object procurarPorName(@RequestBody Funcionarios name) {
        try {
            Funcionarios funcionario = repository.findByName(name.getName());
            if(funcionario == null){
                return "Funcionario nao existe ";
            }
            else {
                return funcionario;
            }
        } catch (Exception e) {
            return   e;
        }
		
	}
    @PostMapping("/ProcurarPoridentification")
	public @ResponseBody Object procurarPoridentification(@RequestBody Funcionarios identification) {
        try {
            Funcionarios funcionario = repository.findByIdentification(identification.getIdentification());
            if(funcionario == null){
                return "Funcionario nao existe ";
                
            }else{
                return funcionario;
            }
        } catch (Exception e) {
            return e;
        }
		
	}
	@PostMapping("/Salvar")
	public @ResponseBody Object salvarFuncionarios(@RequestBody Funcionarios funcionario) {
        try {
            if(repository.findByName(funcionario.getName()) != null){
                return "Funcionario existente, nome: " + funcionario.getName();
            }
            else if(repository.findByIdentification(funcionario.getIdentification()) != null){
                return "Funcionario existente, identicacao: " + funcionario.getIdentification();
            }else{
                //funcionario.setPassword(encoder.encode(funcionario.getPassword()));
                return repository.save(funcionario);
            }
        } catch (Exception e) {
            return e;
        }
		
	}
    @PostMapping("/cadastrar")
	public @ResponseBody Object cadastrar(@RequestBody Funcionarios funcionario) {
        try {
            if(repository.findByName(funcionario.getName()) != null){
                return "Funcionario existente, nome: " + funcionario.getName();
            }
            else if(repository.findByIdentification(funcionario.getIdentification()) != null || funcionario.getIdentification() == null){
                return "Funcionario existente, identicacao: " + funcionario.getIdentification();
            }else{
                Funcionarios newFuncionario = new Funcionarios();
                newFuncionario.cadastrar(funcionario.getPassword(), funcionario.getUserName(), funcionario.getUserName(), funcionario.getIdentification());
                //funcionario.setPassword(encoder.encode(funcionario.getPassword()));
                return repository.save(newFuncionario);
            }
        } catch (Exception e) {
            return e;
        }
		
	}
    @PostMapping("/login")
	public @ResponseBody Object login(@RequestBody Funcionarios funcionario) {
        try {
            if(funcionario.getUserName() == null || funcionario.getPassword() == null){
                return "login invalido";
            }
            Funcionarios funcionarioLogin = repository.findByName(funcionario.getUserName());
            if(funcionarioLogin == null){
                return "login invalido";
            }else if(funcionarioLogin.getPassword() == funcionario.getPassword()){
                return true;
            }else{
                return "login invalido";
            }
        } catch (Exception e) {
            return e;
        }
		
	}
    @PostMapping("/SalvarLista")
	public @ResponseBody Object salvarFuncionariosLista(@RequestBody List<Funcionarios> funcionario) {
		try {
            List<Object> lista = new ArrayList<Object>();
            try {
                for(int i = 0; i<funcionario.size(); i ++){
                    lista.add(salvarFuncionarios(funcionario.get(i)));
                }
            } catch (Exception e) {
                lista.add(e);
            }
            return lista;
        } catch (Exception e) {
            return e;
        }
	}
    @DeleteMapping("/Deletar")
    public @ResponseBody Object deletar(@RequestBody Funcionarios funcionario){
        try {
            repository.delete(funcionario);
        return funcionario;
        } catch (Exception e) {
            return e;
        }
    }
}
