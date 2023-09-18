package com.lab02.aluguelveiculos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "automoveis")
public class Automovel {
    
    @Id
    private int matricula;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String placa;


    public Automovel() {
    }

    public Automovel(int matricula, int ano, String marca, String modelo, String placa) {
        this.matricula = matricula;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
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


}
