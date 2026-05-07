package com.accenture.aluno.controller;

import com.accenture.aluno.domain.Aluno;
import com.accenture.aluno.service.AlunoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> getAllAluno() { return service.findAll(); }

    @PostMapping
    public Aluno saveAluno(@RequestBody Aluno aluno) { return service.save(aluno); }

    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable Long id) { return service.findById(id); }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/botafogo")
    public String botafogo() { return "Botafogo Campeão!"; }
}