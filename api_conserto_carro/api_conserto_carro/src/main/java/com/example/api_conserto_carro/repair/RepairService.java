package com.example.api_conserto_carro.repair;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RepairService {
    @Autowired
    private RepositoryRepair repository;

    public ResponseEntity<String> changeDados(Long id, String nome, Integer anosExperiencia) {
        if(repository.findById(id).isEmpty()) return ResponseEntity.notFound().build();

        var repair = repository.findById(id).get();
        if (!nome.isBlank()) repair.setMechanicName(nome);
        if (anosExperiencia != null) repair.setMechanicExperience(anosExperiencia);
        repository.save(repair);
        return ResponseEntity.ok("Mecanico atualizado!");
    }

    public ResponseEntity<String> changeData(Long id, String dataDeSaida) {
        if(repository.findById(id).isEmpty()) return ResponseEntity.notFound().build();

        var repair = repository.findById(id).get();
        repair.setDataSaida(dataDeSaida);
        repository.save(repair);
        return ResponseEntity.ok("data atualizada com sucesso!");
    }
}
