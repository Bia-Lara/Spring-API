package com.example.api_conserto_carro.repair;

import com.example.api_conserto_carro.mechanic.Mechanic;
import com.example.api_conserto_carro.vehicle.Vehicle;
import com.example.api_conserto_carro.vehicle.VehicleDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @Setter
    private String dataSaida;
    private boolean ativo;

    @Embedded
    private Mechanic mechanic;
    @Embedded
    private Vehicle vehicle;


    public Repair(RepairDto dto) {
        this.dataEntrada = dto.dataEntrada();
        this.dataSaida = dto.dataSaida();
        this.ativo = dto.ativo();
        this.mechanic = new Mechanic(dto.mechanic());
        this.vehicle = new Vehicle(dto.vehicle());
    }

    public void setMechanicName(String nome) {
        mechanic.setNome(nome);
    }

    public void setMechanicExperience(int experience) {
        mechanic.setAnosExperiencia(experience);
    }

}
