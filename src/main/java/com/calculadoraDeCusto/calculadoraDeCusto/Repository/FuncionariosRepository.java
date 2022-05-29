package com.calculadoraDeCusto.calculadoraDeCusto.Repository;

import com.calculadoraDeCusto.calculadoraDeCusto.Model.Funcionarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer>{
    Funcionarios findByName(String name);
    Funcionarios findByIdentification(String identification);
}
