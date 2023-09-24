package com.lab02.aluguelveiculos.repositories;

import com.lab02.aluguelveiculos.models.Pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
    List<Pedido> findByPendenteTrue();
}
