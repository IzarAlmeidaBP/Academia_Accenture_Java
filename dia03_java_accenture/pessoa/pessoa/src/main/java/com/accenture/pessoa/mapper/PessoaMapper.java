package com.accenture.pessoa.mapper;

import com.accenture.pessoa.controller.request.PessoaRequest;
import com.accenture.pessoa.controller.response.PessoaResponse;
import com.accenture.pessoa.domain.Pessoa;

public class PessoaMapper {

    public static Pessoa toEntity(PessoaRequest request) {
        return Pessoa.builder()
                .nome(request.getNome())
                .build();
    }

    public static PessoaResponse toResponse(Pessoa pessoa) {
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .build();
    }
}