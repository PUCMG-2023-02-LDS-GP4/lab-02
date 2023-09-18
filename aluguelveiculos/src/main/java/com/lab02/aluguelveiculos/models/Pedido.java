package com.lab02.aluguelveiculos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private String cor;


    public Pedido(int idPedido, String modelo, String placa, Date data, String cor) {
        this.idPedido = idPedido;
        this.modelo = modelo;
        this.placa = placa;
        this.data = data;
        this.cor = cor;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.toUpperCase();
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor.toUpperCase();
    }

}
