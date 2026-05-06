package com.accenture.consumo.service;

import com.accenture.consumo.domain.Endereco;
import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final CepService cepService;
    private final EnderecoRepository repository;

    public EnderecoService(CepService cepService, EnderecoRepository repository) {
        this.cepService = cepService;
        this.repository = repository;
    }

    public Endereco consultarESalvarCep(String cep) {
        Endereco endereco = cepService.buscaEnderecoPorCep(cep);
        if (endereco != null && endereco.getCep() != null) {
            repository.save(endereco);
        }
        return endereco;
    }
}