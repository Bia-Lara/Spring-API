package com.example.api_conserto_carro.mechanic;

import jakarta.validation.constraints.NotBlank;

public record MechanicDto(
        @NotBlank
        String nome,

        int anosExperiencia
) {
}
