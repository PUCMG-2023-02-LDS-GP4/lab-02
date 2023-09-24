package com.lab02.aluguelveiculos.controllers;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.models.Pedido;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.repositories.PedidoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AutomovelRepository automovelRepository;

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        if (pedido.getAutomovel() == null || pedido.getAutomovel().getMatricula() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Automovel> automovelOpt = automovelRepository.findById(pedido.getAutomovel().getMatricula());

        if (!automovelOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Automovel automovel = automovelOpt.get();
        pedido.setAutomovel(automovel);
        
        pedidoRepository.save(pedido);

        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) {
        Pedido pedido = pedidoRepository.getReferenceById(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}
