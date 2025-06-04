package com.example.api_conserto_carro.user;

import jakarta.validation.constraints.NotBlank;

public record authenticationData(
        @NotBlank
        String login,

        @NotBlank
        String senha
) {}
