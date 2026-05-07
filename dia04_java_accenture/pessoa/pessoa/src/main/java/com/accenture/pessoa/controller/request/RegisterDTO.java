package com.accenture.pessoa.controller.request;

import com.accenture.pessoa.domain.enums.UserRoles;

public record RegisterDTO(String login, String password, UserRoles role) {
}