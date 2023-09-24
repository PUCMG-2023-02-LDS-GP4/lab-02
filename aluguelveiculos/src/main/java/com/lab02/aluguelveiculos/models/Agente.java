package com.lab02.aluguelveiculos.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "agentes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agente extends Usuario {

    public enum TipoAgente {
        EMPRESA,
        BANCO
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAgente tipoAgente;

    @Column(nullable = false)
    private String statusAgente;


    public Agente() {
    }

    public Agente(TipoAgente tipoAgente, String statusAgente) {

        this.tipoAgente = tipoAgente;
        this.statusAgente = statusAgente;
    }

    public TipoAgente getTipoAgente() {
        return this.tipoAgente;
    }

    public void setTipoAgente(TipoAgente tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    public String getStatusAgente() {
        return this.statusAgente;
    }

    public void setStatusAgente(String statusAgente) {
        this.statusAgente = statusAgente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Agente)) {
            return false;
        }
        Agente agente = (Agente) o;
        return Objects.equals(tipoAgente, agente.tipoAgente) && Objects.equals(statusAgente, agente.statusAgente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoAgente, statusAgente);
    }

    @Override
    public String toString() {
        return "{" +
            ", tipoAgente='" + getTipoAgente() + "'" +
            ", statusAgente='" + getStatusAgente() + "'" +
            "}";
    }

    public void modificarPedido(int idPedido) {

    }

    public void executarContrato(int idPedido) {

    }

    public void avaliarCredito() {
        if(this.tipoAgente == TipoAgente.BANCO) {
            // Implementar a avaliação de crédito aqui.
        } else {
            throw new UnsupportedOperationException("Avaliação de crédito só pode ser feita por um agente bancário.");
        }
    }
}
