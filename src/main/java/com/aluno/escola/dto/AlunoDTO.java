package com.aluno.escola.dto;

import com.aluno.escola.entities.Aluno;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


public class AlunoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Integer idade;
    private String plano;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String nome, Integer idade, String plano) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.plano = plano;
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.idade = aluno.getIdade();
        this.plano = aluno.getPlano();
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
