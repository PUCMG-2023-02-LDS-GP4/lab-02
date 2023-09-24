package com.lab02.aluguelveiculos.repositories;

import com.lab02.aluguelveiculos.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
