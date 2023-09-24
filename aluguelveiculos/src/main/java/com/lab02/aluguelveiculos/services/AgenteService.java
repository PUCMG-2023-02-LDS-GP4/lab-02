package com.lab02.aluguelveiculos.services;

import com.lab02.aluguelveiculos.models.Agente;
import com.lab02.aluguelveiculos.repositories.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteService {
    
    @Autowired
    private AgenteRepository agenteRepository;

    public Agente getById(int id) {
        return agenteRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Agente não encontrado com o ID: " + id));
    }
}
