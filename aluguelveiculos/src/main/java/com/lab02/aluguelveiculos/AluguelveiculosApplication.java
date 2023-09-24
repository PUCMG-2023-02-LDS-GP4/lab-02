package com.lab02.aluguelveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.lab02.aluguelveiculos.models"})
public class AluguelveiculosApplication {


	public static void main(String[] args) {
		SpringApplication.run(AluguelveiculosApplication.class, args);
	}


}
