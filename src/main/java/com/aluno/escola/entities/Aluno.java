package com.aluno.escola.entities;

import com.aluno.escola.dto.AlunoDTO;
import jakarta.persistence.*;

@Table(name = "tb_aluno")
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer idade;

    private String plano;

    public Aluno() {
    }

    public Aluno(Long id, String name, Integer idade, String plano) {
        this.id = id;
        this.nome = name;
        this.idade = idade;
        this.plano = plano;
    }

    public Aluno(AlunoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.idade = dto.getIdade();
        this.plano = dto.getPlano();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
}
