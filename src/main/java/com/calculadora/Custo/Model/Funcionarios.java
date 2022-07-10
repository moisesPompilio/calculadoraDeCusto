package com.calculadora.Custo.Model;

import javax.persistence.Column;
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
	private String userName;
	private String password; 
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void cadastrar(String password, String userName, String name, String identification){
		this.password = password;
		this.userName = userName;
		this.name = name;
		this.identification = identification;
	}
    
}
