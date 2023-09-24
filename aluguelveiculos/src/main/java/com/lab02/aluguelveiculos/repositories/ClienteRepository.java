package com.lab02.aluguelveiculos.repositories;

import com.lab02.aluguelveiculos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
