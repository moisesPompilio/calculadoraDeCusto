package com.calculadora.Custo.Model;

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
    private int id;
    private int funcionario;
    private int projects;
    public int getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }
    public int getProjects() {
        return projects;
    }
    public void setProjects(int projects) {
        this.projects = projects;
    }
    public int getId() {
        return id;
    }
    
}
