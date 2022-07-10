package com.calculadora.Custo.Reposiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.Custo.Model.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Integer>{

    Projects findByName(String name);

	List<Projects> findAll();
    
    Projects findById(int id);
}
