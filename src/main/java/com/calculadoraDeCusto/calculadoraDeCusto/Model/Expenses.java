package com.calculadoraDeCusto.calculadoraDeCusto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Member meber;
    private float hour;
    private float value;
    private Boolean maintenance;
    public Expenses(Projects project, Funcionarios funcionario, float hour, float value) {
        Member id = new Member(funcionario, project);
        this.meber = id;
        this.hour = hour;
        this.value = value;
        this.maintenance = project.getClosed();
    }
    public float getHour() {
        return hour;
    }
    public float getValue() {
        return value;
    }
    public Boolean getMaintenance() {
        return maintenance;
    }
    public Member getMeber() {
        return meber;
    }
    public void setMeber(Member meber) {
        this.meber = meber;
    }
}
