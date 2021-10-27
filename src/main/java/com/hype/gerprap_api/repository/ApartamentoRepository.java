package com.hype.gerprap_api.repository;

import java.util.Optional;

import com.hype.gerprap_api.entity.Apartamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{
    
    Optional<Apartamento> findByCodigo(String codigo);

}
