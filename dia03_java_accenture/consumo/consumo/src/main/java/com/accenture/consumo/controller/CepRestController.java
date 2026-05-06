package com.accenture.consumo.controller;

import com.accenture.consumo.domain.Endereco;
import com.accenture.consumo.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepRestController {

    private final EnderecoService enderecoService;

    public CepRestController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        Endereco endereco = enderecoService.consultarESalvarCep(cep);
        return endereco != null && endereco.getCep() != null
                ? ResponseEntity.ok().body(endereco)
                : ResponseEntity.notFound().build();
    }
}