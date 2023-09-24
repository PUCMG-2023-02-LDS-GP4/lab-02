package com.lab02.aluguelveiculos.controllers;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelRepository automovelRepository;

    @PostMapping
    public ResponseEntity<Automovel> createAutomovel(@RequestBody Automovel automovel) {
        Automovel savedAutomovel = automovelRepository.save(automovel);
        return ResponseEntity.ok(savedAutomovel);
    }
}
