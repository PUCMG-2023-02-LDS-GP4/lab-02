package com.lab02.aluguelveiculos.controllers;

import com.lab02.aluguelveiculos.models.Automovel;
import com.lab02.aluguelveiculos.models.Contrato;
import com.lab02.aluguelveiculos.models.Pedido;
import com.lab02.aluguelveiculos.services.ContratoService;
import com.lab02.aluguelveiculos.repositories.AgenteRepository;
import com.lab02.aluguelveiculos.repositories.AutomovelRepository;
import com.lab02.aluguelveiculos.repositories.ClienteRepository;
import com.lab02.aluguelveiculos.repositories.ContratoRepository;
import com.lab02.aluguelveiculos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lab02.aluguelveiculos.models.Cliente;
import com.lab02.aluguelveiculos.models.Agente;

import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private AutomovelRepository automovelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgenteRepository agenteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> getContratoById(@PathVariable int id) {
        Contrato contrato = contratoService.getById(id);
        return new ResponseEntity<>(contrato, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Contrato> createContrato(@RequestBody Contrato contrato) {

        Optional<Automovel> automovelOpt = automovelRepository.findById(contrato.getAutomovel().getMatricula());



        Optional<Cliente> clienteOpt = clienteRepository.findById(contrato.getCliente().getId());



        Optional<Agente> agenteOpt = agenteRepository.findById(contrato.getAgente().getId());



        Agente agente = agenteOpt.get();
        contrato.setAgente(agente);
        Cliente cliente = clienteOpt.get();
        contrato.setCliente(cliente);
        Automovel automovel = automovelOpt.get();
        contrato.setAutomovel(automovel);
        
        contratoRepository.save(contrato);

        return new ResponseEntity<>(contrato, HttpStatus.CREATED);
    }
}
