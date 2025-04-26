package com.example.api_conserto_carro.repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryRepair extends JpaRepository<Repair, Long> {
    Page<Repair> findByAtivoTrue(Pageable pageable);
}
