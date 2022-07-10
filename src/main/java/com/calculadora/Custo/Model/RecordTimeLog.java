package com.calculadora.Custo.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class RecordTimeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private Boolean saida;
    @ManyToOne
    @JoinColumn(name = "meber_id")
    private Member participant;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void IsertDate() {
        this.date = new Date();
    }
    public Boolean getSaida() {
        return saida;
    }
    public void setSaida(Boolean saida) {
        this.saida = saida;
    }
    public Member getParticipant() {
        return participant;
    }
    public void setParticipant(Member participant) {
        this.participant = participant;
    }
    public int getId() {
        return id;
    }
}
