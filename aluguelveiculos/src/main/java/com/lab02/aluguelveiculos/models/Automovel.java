package com.lab02.aluguelveiculos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "automoveis")
public class Automovel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula", unique = true)
    private int matricula;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private Boolean disponivel;


    public Automovel() {
    }

    public Automovel(int ano, String marca, String modelo, String placa, Boolean disponivel) {
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.disponivel = disponivel;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean isDisponivel() {
        return this.disponivel;
    }

    public Boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Automovel)) {
            return false;
        }
        Automovel automovel = (Automovel) o;
        return matricula == automovel.matricula && ano == automovel.ano && Objects.equals(marca, automovel.marca) && Objects.equals(modelo, automovel.modelo) && Objects.equals(placa, automovel.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, ano, marca, modelo, placa);
    }

    @Override
    public String toString() {
        return "{" +
            " matricula='" + getMatricula() + "'" +
            ", ano='" + getAno() + "'" +
            ", marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", placa='" + getPlaca() + "'" +
            "}";
    }

    public List<Automovel> listarCarrosDisponiveis() {
        List<Automovel> listaAutomoveis = new ArrayList<Automovel>();
        return listaAutomoveis.stream()
            .filter(automovel -> !automovel.isDisponivel()) // Assumindo que a classe Automovel tem um método isAlugado.
            .collect(Collectors.toList());
    }

}
