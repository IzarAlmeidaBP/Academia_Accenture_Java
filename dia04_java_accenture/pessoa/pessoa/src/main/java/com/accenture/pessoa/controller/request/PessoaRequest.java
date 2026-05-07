package com.accenture.pessoa.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaRequest {
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;
}