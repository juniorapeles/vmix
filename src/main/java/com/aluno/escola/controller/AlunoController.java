package com.aluno.escola.controller;

import com.aluno.escola.dto.AlunoDTO;
import com.aluno.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<AlunoDTO> findAll(){
        return service.findAll2();
    }

    @GetMapping("/{id}")
    public AlunoDTO findById(Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public AlunoDTO updateByIid(@PathVariable Long id, @RequestBody AlunoDTO dto){
        return service.updateById(id,dto);
    }

    @PostMapping
    public AlunoDTO insert(@RequestBody AlunoDTO dto){
       return service.insert(dto);
    }
}
