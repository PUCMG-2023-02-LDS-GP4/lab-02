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
@Table(name = "agentes")
public class Agente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgente;

    @Column(nullable = false)
    private String tipoAgente;

    @Column(nullable = false)
    private String statusAgente;


    public Agente() {
    }

    public Agente(int idAgente, String tipoAgente, String statusAgente) {
        this.idAgente = idAgente;
        this.tipoAgente = tipoAgente;
        this.statusAgente = statusAgente;
    }

    public int getIdAgente() {
        return this.idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public String getTipoAgente() {
        return this.tipoAgente;
    }

    public void setTipoAgente(String tipoAgente) {
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
        return idAgente == agente.idAgente && Objects.equals(tipoAgente, agente.tipoAgente) && Objects.equals(statusAgente, agente.statusAgente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgente, tipoAgente, statusAgente);
    }

    @Override
    public String toString() {
        return "{" +
            " idAgente='" + getIdAgente() + "'" +
            ", tipoAgente='" + getTipoAgente() + "'" +
            ", statusAgente='" + getStatusAgente() + "'" +
            "}";
    }

    public void modificarPedido(int idPedido) {

    }

    public void executarContrato(int idPedido) {

    }
}
