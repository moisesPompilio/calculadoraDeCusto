package com.calculadoraDeCusto.calculadoraDeCusto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int funcionario_id;
    private int projects_id;
    public Member(Funcionarios funcionario_id, Projects projects_id) {
        this.funcionario_id = funcionario_id.getId();
        this.projects_id = projects_id.getId();
    }
    public int getFuncionario_id() {
        return funcionario_id;
    }
    public void setFuncionario_id(Funcionarios funcionario_id) {
        this.funcionario_id = funcionario_id.getId();
    }
    public int getProjects_id() {
        return projects_id;
    }
    public void setProjects_id(Projects projects_id) {
        this.projects_id = projects_id.getId();
    }
    
}
