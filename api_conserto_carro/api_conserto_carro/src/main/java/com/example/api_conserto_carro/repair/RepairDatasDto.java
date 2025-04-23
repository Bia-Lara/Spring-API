package com.example.api_conserto_carro.repair;

import com.example.api_conserto_carro.mechanic.MechanicDto;
import com.example.api_conserto_carro.vehicle.VehicleDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RepairDatasDto(
        String dataEntrada,
        String dataSaida,
        String nome,
        String marca,
        String modelo

) {

    public RepairDatasDto(Repair repair){
        this(
                repair.getDataEntrada(),
                repair.getDataSaida(),
                repair.getMechanic().getNome(),
                repair.getVehicle().getMarca(),
                repair.getVehicle().getModelo()
        );
    }

}
