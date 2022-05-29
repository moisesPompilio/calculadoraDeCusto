package com.calculadoraDeCusto.calculadoraDeCusto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Funcionarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float valueHours;
    private String identification;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValueHours() {
		return valueHours;
	}
	public void setValueHours(float valueHours) {
		this.valueHours = valueHours;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
    
    
    
}

