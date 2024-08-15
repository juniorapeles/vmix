package com.aluno.escola.repositories;

import com.aluno.escola.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByIdadeGreaterThanAndPlano(Integer idade, String plano);
}
