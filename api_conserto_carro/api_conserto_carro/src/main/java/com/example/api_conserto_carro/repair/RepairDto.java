package com.example.api_conserto_carro.repair;

import com.example.api_conserto_carro.mechanic.Mechanic;
import com.example.api_conserto_carro.mechanic.MechanicDto;
import com.example.api_conserto_carro.vehicle.Vehicle;
import com.example.api_conserto_carro.vehicle.VehicleDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Locale;

public record RepairDto(
        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataEntrada,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        MechanicDto mechanic,
        VehicleDto vehicle
) {
}
