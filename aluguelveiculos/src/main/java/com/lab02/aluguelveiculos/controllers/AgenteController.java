package com.lab02.aluguelveiculos.controllers;

import com.lab02.aluguelveiculos.models.*;
import com.lab02.aluguelveiculos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/agentes")
public class AgenteController {

    @Autowired
    private AgenteRepository agenteRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Agente> createAgente(@RequestBody Agente agente) {
        Agente savedAgente = agenteRepository.save(agente);
        return ResponseEntity.ok(savedAgente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agente> getAgenteById(@PathVariable int id) {
        Agente agente = agenteRepository.getById(id);
        return ResponseEntity.ok(agente);
    }

}
