package com.example.api_conserto_carro.repair;

import com.example.api_conserto_carro.mechanic.Mechanic;
import com.example.api_conserto_carro.vehicle.Vehicle;
import com.example.api_conserto_carro.vehicle.VehicleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mechanic mechanic;
    @Embedded
    private Vehicle vehicle;


    public Repair(RepairDto dto) {
        this.dataEntrada = dto.dataEntrada();
        this.dataSaida = dto.dataSaida();
        this.mechanic = new Mechanic(dto.mechanic());
        this.vehicle = new Vehicle(dto.vehicle());
    }
}
