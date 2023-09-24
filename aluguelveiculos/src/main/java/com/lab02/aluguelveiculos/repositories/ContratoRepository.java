package com.lab02.aluguelveiculos.repositories;

import com.lab02.aluguelveiculos.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    
}
