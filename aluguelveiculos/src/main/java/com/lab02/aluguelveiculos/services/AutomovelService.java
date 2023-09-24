package com.lab02.aluguelveiculos.services;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.models.Pedido;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.repositories.PedidoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutomovelService {

    private final AutomovelRepository automovelRepository;

    public AutomovelService(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    public Automovel getById(int id) {
        return automovelRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Automóvel não encontrado com o ID: " + id));
    }

    public List<Automovel> listarCarrosDisponiveis() {
        return automovelRepository.findByDisponivelTrue();
    }
}
