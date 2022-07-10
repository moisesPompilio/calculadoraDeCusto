package com.calculadora.Custo.Reposiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.Custo.Model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findAll();
    List<Member> findByProjects(int projects_id);
    List<Member> findByFuncionario(int funcionario);
}
