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
@Table(name = "clientes")
public class Cliente extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String RG;

    @Column(nullable = false)
    private int CPF;

    @Column(nullable = false)
    private String nome;

    @Column
    private String endereco;

    @Column
    private String profissao;

    @Column
    private String empresaEmpregadora;

    @OneToMany // Supondo que cada rendimento é uma entidade separada.
    private List<Float> rendimentos = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(Long id, String RG, int CPF, String nome, String endereco, String profissao, String empresaEmpregadora, List<Float> rendimentos) {
        this.id = id;
        this.RG = RG;
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
        this.empresaEmpregadora = empresaEmpregadora;
        this.rendimentos = rendimentos;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRG() {
        return this.RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public int getCPF() {
        return this.CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmpresaEmpregadora() {
        return this.empresaEmpregadora;
    }

    public void setEmpresaEmpregadora(String empresaEmpregadora) {
        this.empresaEmpregadora = empresaEmpregadora;
    }

    public List<Float> getRendimentos() {
        return this.rendimentos;
    }

    public void setRendimentos(List<Float> rendimentos) {
        this.rendimentos = rendimentos;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && CPF == cliente.CPF && Objects.equals(nome, cliente.nome) && Objects.equals(endereco, cliente.endereco) && Objects.equals(profissao, cliente.profissao) && Objects.equals(empresaEmpregadora, cliente.empresaEmpregadora) && Objects.equals(rendimentos, cliente.rendimentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CPF, nome, endereco, profissao, empresaEmpregadora, rendimentos);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", CPF='" + getCPF() + "'" +
            ", nome='" + getNome() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", profissao='" + getProfissao() + "'" +
            ", empresaEmpregadora='" + getEmpresaEmpregadora() + "'" +
            ", rendimentos='" + getRendimentos() + "'" +
            "}";
    }
    

    public void introduzirPedido(int id, int idPedido) {
        
    }
}
