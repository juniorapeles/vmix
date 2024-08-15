package com.aluno.escola.service;

import com.aluno.escola.dto.AlunoDTO;
import com.aluno.escola.entities.Aluno;
import com.aluno.escola.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;


    public List<AlunoDTO> findAll() {
        List<Aluno> alunos = repository.findAll();
        return alunos.stream()
                .map(AlunoDTO::new)
                .collect(Collectors.toList());
    }

    public AlunoDTO findById(Long id ) {
        Optional<Aluno> obj = repository.findById(id);
        Aluno ent = obj.orElseThrow(() -> new RuntimeException("id not found"+ id));
        return new AlunoDTO(ent);
    }

    public List<AlunoDTO> findAll2() {
        return repository.findByIdadeGreaterThanAndPlano(50, "SMART")
                .stream()
                .map(AlunoDTO::new)
                .collect(Collectors.toList());
    }

    public AlunoDTO updateById(Long id, AlunoDTO dto) {
        try {
            Aluno aluno = repository.getReferenceById(id);
            aluno.setPlano(dto.getPlano());
            repository.save(aluno);
            return new AlunoDTO(aluno);
        } catch (RuntimeException e) {
            throw new RuntimeException("Aluno não encontrado com ID: " + id);
        }
    }

    public AlunoDTO insert(AlunoDTO dto) {
        if (dto.getIdade() >= 16) {
            Aluno aluno = new Aluno(dto);
            repository.save(aluno);
            return new AlunoDTO(aluno);
        } else {
            throw new RuntimeException("Idade não permitida");
        }
    }
}
