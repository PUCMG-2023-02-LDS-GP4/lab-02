package com.lab02.aluguelveiculos.models;

import javax.persistence.Entity;
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
@Table(name = "clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente extends Usuario{
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String profissao;

    @Column
    private String empresaEmpregadora;

    private float[] rendimentos = new float[3]; 

    @OneToMany 
    private List<Pedido> pedidosCliente = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int id, String rg, String cpf, String nome, String endereco, String profissao, String empresaEmpregadora, float[] rendimentos, List<Pedido> pedidosCliente) {
        this.id = id;
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
        this.empresaEmpregadora = empresaEmpregadora;
        this.rendimentos = rendimentos; 
        this.pedidosCliente = pedidosCliente;
    }

    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getRG() {
        return this.rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
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

    public float[] getRendimentos() {
        return this.rendimentos;
    }

    public void setRendimentos(float[] rendimentos) {
        if (rendimentos.length <= 3) {
            this.rendimentos = rendimentos;
        } else {
            throw new IllegalArgumentException("O número de rendimentos não pode ser maior que 3");
        }
    }

    public List<Pedido> getPedidosCliente() {
        return this.pedidosCliente;
    }

    public void setPedidosCliente(List<Pedido> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    } 

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && cpf == cliente.cpf && Objects.equals(nome, cliente.nome) && Objects.equals(endereco, cliente.endereco) && Objects.equals(profissao, cliente.profissao) && Objects.equals(empresaEmpregadora, cliente.empresaEmpregadora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, nome, endereco, profissao, empresaEmpregadora);
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
            "}";
    }
    

    public void introduzirPedido(int id, int idPedido) {
        
    }
}
