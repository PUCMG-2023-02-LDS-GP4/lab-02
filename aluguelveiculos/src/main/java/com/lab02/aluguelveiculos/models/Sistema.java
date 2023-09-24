package com.lab02.aluguelveiculos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
    private List<Pedido> listaPedidos;
    private List<Automovel> listaAutomoveis;
    
    public Sistema() {
        this.listaPedidos = new ArrayList<>();
        this.listaAutomoveis = new ArrayList<>();
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<Automovel> getListaAutomoveis() {
        return listaAutomoveis;
    }

    public void setListaAutomoveis(List<Automovel> listaAutomoveis) {
        this.listaAutomoveis = listaAutomoveis;
    }

    public List<Automovel> listarCarrosDisponiveis() {
        return listaAutomoveis.stream()
            .filter(automovel -> !automovel.isDisponivel()) // Assumindo que a classe Automovel tem um método isAlugado.
            .collect(Collectors.toList());
    }

    public List<Pedido> listarPedidosPendentes() {
        return listaPedidos.stream()
            .filter(pedido -> pedido.isPendente()) // Assumindo que a classe Pedido tem um método isPendente.
            .collect(Collectors.toList());
    }
}
