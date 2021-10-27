package com.hype.gerprap_api.repository;

import com.hype.gerprap_api.entity.Predio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PredioRepository extends JpaRepository<Predio, Long> {
    
}
