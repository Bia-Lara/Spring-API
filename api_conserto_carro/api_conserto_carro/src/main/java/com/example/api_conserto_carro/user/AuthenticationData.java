package com.example.api_conserto_carro.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
        @NotBlank
        String login,

        @NotBlank
        String senha
) {}
