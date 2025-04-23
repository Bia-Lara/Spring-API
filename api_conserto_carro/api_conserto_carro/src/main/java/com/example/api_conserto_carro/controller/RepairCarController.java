package com.example.api_conserto_carro.controller;
import com.example.api_conserto_carro.repair.Repair;
import com.example.api_conserto_carro.repair.RepairDatasDto;
import com.example.api_conserto_carro.repair.RepairDto;
import com.example.api_conserto_carro.repair.RepositoryRepair;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consertos")
public class RepairCarController {
    @Autowired
    private RepositoryRepair repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RepairDto data){
        repository.save(new Repair(data));
    }

    @GetMapping
    public Page<Repair> findAll(Pageable pagination){
        return repository.findAll(pagination);
    }

    @GetMapping("showRepairs")
    public List<RepairDatasDto> showRepairs(){
        return repository.findAll().stream().map(RepairDatasDto::new).toList();
    }
}
