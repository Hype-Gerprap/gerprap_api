package com.hype.gerprap_api.repository;

import java.util.List;
import java.util.Optional;

import com.hype.gerprap_api.entity.Predio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PredioRepository extends JpaRepository<Predio, Long> {
    
    List<Predio> findAllByNome(String nome);

    Optional<Predio> findByNome(String nome);

}
