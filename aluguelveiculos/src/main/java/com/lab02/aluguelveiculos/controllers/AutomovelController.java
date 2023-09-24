package com.lab02.aluguelveiculos.controllers;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.models.Pedido;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.services.AutomovelService;
import com.lab02.aluguelveiculos.services.PedidoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automoveis")
public class AutomovelController {

    private final AutomovelService automovelService;

    @Autowired
    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

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

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Automovel>> listarCarrosDisponiveis() {
        return ResponseEntity.ok(automovelService.listarCarrosDisponiveis());
    }
}
