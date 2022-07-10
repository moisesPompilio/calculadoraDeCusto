package com.calculadora.Custo.Reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.Custo.Model.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Integer> {
    Funcionarios findByName(String name);
    Funcionarios findByIdentification(String identification);
    Funcionarios findById(int i);
    Funcionarios findByUserName(String username);
}
