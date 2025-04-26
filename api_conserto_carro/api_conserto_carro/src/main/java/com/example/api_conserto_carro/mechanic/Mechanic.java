package com.example.api_conserto_carro.mechanic;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic {
    private String nome;
    private int anosExperiencia;

    public Mechanic(MechanicDto dto) {
        this.nome = dto.nome();
        this.anosExperiencia = dto.anosExperiencia();
    }
}
