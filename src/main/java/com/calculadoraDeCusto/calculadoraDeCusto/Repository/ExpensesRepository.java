package com.calculadoraDeCusto.calculadoraDeCusto.Repository;

import com.calculadoraDeCusto.calculadoraDeCusto.Model.Expenses;
import com.calculadoraDeCusto.calculadoraDeCusto.Model.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses, Member>{
    
}
