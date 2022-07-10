package com.calculadora.Custo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "meber_id")
    private Member meber;
    private float hour;
    private float value;
    private Boolean maintenance;
    private int[] entradaSaida;
    public Member getMeber() {
        return meber;
    }
    public void setMeber(Member meber) {
        this.meber = meber;
    }
    public float getHour() {
        return hour;
    }
    public void setHour(float hour) {
        this.hour = hour;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    public Boolean getMaintenance() {
        return maintenance;
    }
    public void setMaintenance(Boolean maintenance) {
        this.maintenance = maintenance;
    }
    public int getId() {
        return id;
    }
    public int[] getEntradaSaida() {
        return entradaSaida;
    }
    public void setEntradaSaida(int[] entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

}
