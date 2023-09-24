package com.lab02.aluguelveiculos.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contratos")
public class Contrato {

    public enum TipoContrato {
        CLIENTE,
        EMPRESA,
        BANCO
    }    

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Cliente contratante;

    @ManyToOne
    private Automovel automovel;

    @ManyToOne
    private Agente avaliador;

    @Column
    private Date dataInicio;

    @Column
    private Boolean aprovado;

    @Column
    private TipoContrato tipoContrato;
    
    @Column
    private int proprietarioId;

    public Contrato() {
    }

    public Contrato(Cliente contratante, Automovel automovel, Agente avaliador, Date dataInicio, Boolean aprovado, TipoContrato tipoContrato, int proprietarioId) {
        this.contratante = contratante;
        this.automovel = automovel;
        this.avaliador = avaliador;
        this.dataInicio = dataInicio;
        this.aprovado = false;
        this.tipoContrato = tipoContrato;
        this.proprietarioId = proprietarioId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Automovel getAutomovel() {
        return this.automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Agente getAvaliador() {
        return this.avaliador;
    }

    public void setAvaliador(Agente avaliador) {
        this.avaliador = avaliador;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Boolean isAprovado() {
        return this.aprovado;
    }

    public Boolean getAprovado() {
        return this.aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public TipoContrato getTipoContrato() {
        return this.tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getProprietarioId() {
        return this.proprietarioId;
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public Cliente getContratante() {
        return this.contratante;
    }

    public void setContratante(Cliente contratante) {
        this.contratante = contratante;
    }

    
    
}
