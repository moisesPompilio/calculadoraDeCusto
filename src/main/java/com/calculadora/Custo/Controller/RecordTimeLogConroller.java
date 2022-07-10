package com.calculadora.Custo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.Custo.Model.Member;
import com.calculadora.Custo.Model.RecordTimeLog;
import com.calculadora.Custo.Reposiory.RecordTimeLogRepository;

@RestController
@CrossOrigin
@RequestMapping("/RecordTimeLog")
public class RecordTimeLogConroller {
    @Autowired
    private RecordTimeLogRepository repository;

    @GetMapping("/Listar")
    public @ResponseBody List<RecordTimeLog> listarProjects() {
        return repository.findAll();
    }

    @PostMapping("/ProcurarPorData")
    public @ResponseBody Object procurarPorData(@RequestBody RecordTimeLog date) {
        try {
            List<RecordTimeLog> listRecordTimeLog = repository.findByDate(date.getDate());
            return listRecordTimeLog;
        } catch (Exception e) {
            return e;
        }

    }

    @PostMapping("/ProcurarPorMember")
    public @ResponseBody Object procurarPorMember(@RequestBody Member member) {
        try {
            List<RecordTimeLog> listRecordTimeLog = repository.findByParticipant(member);
            return listRecordTimeLog;
        } catch (Exception e) {
            return e;
        }

    }

    @PostMapping("/Salvar")
    public @ResponseBody List<RecordTimeLog> salvar(@RequestBody Member member) {
        try {
            RecordTimeLog recordTimeLogt = new RecordTimeLog();
            List<RecordTimeLog> listRecordTimeLog = repository.findByParticipant(member);
            recordTimeLogt.setSaida(!listRecordTimeLog.get(listRecordTimeLog.size() - 1).getSaida());
            recordTimeLogt.IsertDate();
            recordTimeLogt.setParticipant(member);
            List<RecordTimeLog> listCusto = new ArrayList<RecordTimeLog>();
            if (recordTimeLogt.getSaida()) {
                listCusto.add(listRecordTimeLog.get(listRecordTimeLog.size() - 1));
                listCusto.add(repository.save(recordTimeLogt));
                return listCusto;
            }
            listCusto.add(repository.save(recordTimeLogt));
            return listCusto;
        } catch (Exception e) {
            return null;
        }

    }

    @PutMapping("/alterar")
    public @ResponseBody Object alterar(@RequestBody RecordTimeLog recordTimeLogt) {
        try {
            return repository.save(recordTimeLogt);

        } catch (Exception e) {
            return e;
        }

    }
}
