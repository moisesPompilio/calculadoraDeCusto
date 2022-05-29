package com.calculadoraDeCusto.calculadoraDeCusto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name; 
    private String description;
    private Funcionarios[] members;
    private Boolean closed;
    private float spentTotal;
    private float hoursSpentTotal;
    private float hoursMaintenance;
    private float spentMaintenance;
    private float hourCreation;
    private float spentCreation;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Funcionarios[] getMembers() {
        return members;
    }
    public void setMembers(Funcionarios[] members) {
        this.members = members;
    }
    public Boolean getClosed() {
        return closed;
    }
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }
    public float getSpentTotal() {
        return spentTotal;
    }
    public void setSpentTotal(float spentTotal) {
        this.spentTotal = spentTotal;
    }
    public float getHoursSpentTotal() {
        return hoursSpentTotal;
    }
    public void setHoursSpentTotal(float hoursSpentTotal) {
        this.hoursSpentTotal = hoursSpentTotal;
    }
    public float getHoursMaintenance() {
        return hoursMaintenance;
    }
    public void setHoursMaintenance(float hoursMaintenance) {
        this.hoursMaintenance = hoursMaintenance;
    }
    public float getSpentMaintenance() {
        return spentMaintenance;
    }
    public void setSpentMaintenance(float spentMaintenance) {
        this.spentMaintenance = spentMaintenance;
    }
    public float getHourCreation() {
        return hourCreation;
    }
    public void setHourCreation(float hourCreation) {
        this.hourCreation = hourCreation;
    }
    public float getSpentCreation() {
        return spentCreation;
    }
    public void setSpentCreation(float spentCreation) {
        this.spentCreation = spentCreation;
    }
}
