package com.calculadora.Custo.Reposiory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.Custo.Model.Member;
import com.calculadora.Custo.Model.RecordTimeLog;

public interface RecordTimeLogRepository extends JpaRepository<RecordTimeLog, Integer>{

    List<RecordTimeLog> findByDate(Date date);
    List<RecordTimeLog> findByParticipant(Member participant);;
}
