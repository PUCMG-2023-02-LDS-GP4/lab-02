package com.lab02.aluguelveiculos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import java.util.Date;


@Entity
@Table(name = "pedidos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @ManyToOne
    @JoinColumn(name = "automovel_matricula")
    private Automovel automovel;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Boolean pendente;

    public Pedido(Date data, Automovel automovel, Boolean pendente) {
        this.data = data;
        this.automovel = automovel;
        this.pendente = pendente;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Automovel getAutomovel() {
        return this.automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean isPendente() {
        return this.pendente;
    }

    public Boolean getPendente() {
        return this.pendente;
    }

    public void setPendente(Boolean pendente) {
        this.pendente = pendente;
    }

}
