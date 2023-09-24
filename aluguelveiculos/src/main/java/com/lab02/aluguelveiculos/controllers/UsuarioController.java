package com.lab02.aluguelveiculos.controllers;

import com.lab02.aluguelveiculos.models.Usuario;
import com.lab02.aluguelveiculos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

}
