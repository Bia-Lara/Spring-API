package com.example.api_conserto_carro.vehicle;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Vehicle(VehicleDto dto) {
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.ano = dto.ano();
        this.cor = dto.cor();
    }
}
