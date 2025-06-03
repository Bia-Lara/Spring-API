package com.example.api_conserto_carro.repair;

import com.example.api_conserto_carro.mechanic.Mechanic;
import com.example.api_conserto_carro.vehicle.Vehicle;
import com.example.api_conserto_carro.vehicle.VehicleDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    @Setter
    private String dataSaida;
    private boolean ativo;

    @Embedded
    private Mechanic mechanic;
    @Embedded
    private Vehicle vehicle;
    private Boolean active;


    public Repair(RepairDto dto) {
        this.active = true;
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

    public void remove(){
        this.active = false;
    }
}
