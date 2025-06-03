package com.example.api_conserto_carro.controller;
import com.example.api_conserto_carro.mechanic.Mechanic;
import com.example.api_conserto_carro.repair.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/consertos")
public class RepairCarController {

    private RepositoryRepair repository;

    @Autowired
    private RepairService service;

    public RepairCarController(RepositoryRepair repository){
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> register(@RequestBody @Valid RepairDto data){

        repository.save(new Repair(data));
        return ResponseEntity.ok("criado com sucesso!");
    }

    @GetMapping
    public Page<Repair> findAll(Pageable pagination){
        return repository.findByAtivoTrue(pagination);
    }

    @GetMapping("showRepairs")
    public ResponseEntity<List<RepairDatasDto>> showRepairs(){
        var repairs = repository.findAll().stream().map(RepairDatasDto::new).toList();
        return ResponseEntity.ok(repairs);
    }

    @GetMapping("repair/{id}")
    public ResponseEntity<RepairDatasDto> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(repair -> ResponseEntity.ok(new RepairDatasDto(repair)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("repair/{id}")
    public ResponseEntity<String> changeData(@PathVariable Long id, @RequestBody Mechanic mechanic) {
        return service.changeDados(id, mechanic.getNome(), mechanic.getAnosExperiencia());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remove(@PathVariable Long id){
        Repair repair = repository.getReferenceById(id);

        repair.remove();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("repair/data-de-saida/{id}")
    @Transactional
    public ResponseEntity<String> changeDataSaida(Long id, String data) {
        return service.changeData(id, data);
    }
}
