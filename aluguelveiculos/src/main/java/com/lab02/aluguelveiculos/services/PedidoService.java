package com.lab02.aluguelveiculos.services;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.models.Pedido;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.repositories.PedidoRepository;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Autowired
    private AutomovelRepository automovelRepository;

    public Pedido criarPedido(Date data, int automovelId, Boolean pendente) {
        Automovel automovel = automovelRepository.findById(automovelId)
                                   .orElseThrow(() -> new RuntimeException("Automóvel não encontrado com o ID: " + automovelId));

        Pedido pedido = new Pedido(data, automovel, pendente);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidosPendentes() {
        return pedidoRepository.findByPendenteTrue();
    }

    public Pedido atualizarPedido(int id, Pedido pedidoAtualizado) {
        Pedido pedidoExistente = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        
        if (pedidoAtualizado.getData() != null) {
            pedidoExistente.setData(pedidoAtualizado.getData());
        }
    
        if (pedidoAtualizado.getAutomovel() != null) {
            pedidoExistente.setAutomovel(pedidoAtualizado.getAutomovel());
        }
    
        if (pedidoAtualizado.getPendente() != null) {
            pedidoExistente.setPendente(pedidoAtualizado.getPendente());
        }
    
        return pedidoRepository.save(pedidoExistente);
    }
    
}
