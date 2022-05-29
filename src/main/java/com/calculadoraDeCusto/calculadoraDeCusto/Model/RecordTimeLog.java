package com.calculadoraDeCusto.calculadoraDeCusto.Model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class RecordTimeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private Boolean saida;
    private Member participant;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
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
    
}
