package com.lab02.aluguelveiculos.services;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.models.Contrato;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository; 

    @Autowired
    private AutomovelRepository automovelRepository;

    public Contrato criarContratoComAutomovel(int automovelId, Contrato contrato) {
        Automovel automovel = automovelRepository.findById(automovelId)
                                   .orElseThrow(() -> new RuntimeException("Automóvel não encontrado"));
        contrato.setAutomovel(automovel);
        return contratoRepository.save(contrato);
    }

    public Contrato getById(int id) {
        return contratoRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Contrato não encontrado com o ID: " + id));
    }
}
