package com.accenture.pessoa.service;

import com.accenture.pessoa.controller.request.PessoaRequest;
import com.accenture.pessoa.controller.response.PessoaResponse;
import com.accenture.pessoa.domain.Pessoa;
import com.accenture.pessoa.mapper.PessoaMapper;
import com.accenture.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<PessoaResponse> getAll() {
        return repository.findAll().stream()
                .map(PessoaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PessoaResponse getById(Long id) {
        return repository.findById(id)
                .map(PessoaMapper::toResponse)
                .orElse(null);
    }

    public void create(PessoaRequest request) {
        repository.save(PessoaMapper.toEntity(request));
    }

    public void update(Long id, PessoaRequest request) {
        repository.findById(id).ifPresent(pessoa -> {
            pessoa.setNome(request.getNome());
            repository.save(pessoa);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}