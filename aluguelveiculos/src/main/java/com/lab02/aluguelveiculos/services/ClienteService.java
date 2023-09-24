package com.lab02.aluguelveiculos.services;

import com.lab02.aluguelveiculos.models.Cliente;
import com.lab02.aluguelveiculos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getById(int id) {
        return clienteRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Agente não encontrado com o ID: " + id));
    }
}
