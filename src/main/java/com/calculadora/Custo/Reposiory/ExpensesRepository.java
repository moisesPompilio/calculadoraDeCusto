package com.calculadora.Custo.Reposiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.Custo.Model.Expenses;
import com.calculadora.Custo.Model.Member;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer>{
    List<Expenses> findByMeber(Member meber);
}
