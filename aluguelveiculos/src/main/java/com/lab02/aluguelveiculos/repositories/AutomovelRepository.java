package com.lab02.aluguelveiculos.repositories;

import com.lab02.aluguelveiculos.models.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Integer> {
}
