package com.lab02.aluguelveiculos.controllers;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.services.AutomovelService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelService automovelService;

    @Autowired
    private AutomovelRepository automovelRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Automovel> createAutomovel(@RequestBody Automovel automovel) {
        Automovel savedAutomovel = automovelRepository.save(automovel);
        return ResponseEntity.ok(savedAutomovel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automovel> getAutomovelById(@PathVariable int id) {
        Automovel automovel = automovelService.getById(id);
        return new ResponseEntity<>(automovel, HttpStatus.OK);
    }

        @GetMapping("/detalhes/{id}")
    public ResponseEntity<Map<String, Object>> getDetalhes(@PathVariable int id) {
        Optional<Automovel> automovelOpt = automovelRepository.findById(id);

        if (!automovelOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Automovel automovel = automovelOpt.get();
        Map<String, Object> response = new HashMap<>();
        response.put("placa", automovel.getPlaca());
        response.put("modelo", automovel.getModelo());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
