package com.lab02.aluguelveiculos.repositories;

import com.lab02.aluguelveiculos.models.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Integer> {
    
}
