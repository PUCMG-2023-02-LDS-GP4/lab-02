package com.lab02.aluguelveiculos.services;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.models.Pedido;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.repositories.PedidoRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AutomovelRepository automovelRepository;

    public Pedido criarPedido(Date data, int automovelId, Boolean pendente) {
        Automovel automovel = automovelRepository.findById(automovelId)
                                   .orElseThrow(() -> new RuntimeException("Automóvel não encontrado com o ID: " + automovelId));

        Pedido pedido = new Pedido(data, automovel, pendente);
        return pedidoRepository.save(pedido);
    }

}
