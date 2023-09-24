package com.lab02.aluguelveiculos.services;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    public Automovel getById(int id) {
        return automovelRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Automóvel não encontrado com o ID: " + id));
    }

}
