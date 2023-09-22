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

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

/*     @OneToMany // Supondo que cada rendimento é uma entidade separada.
    private List<Float> rendimentos = new ArrayList<>(); */


    public Cliente() {
    }

    public Cliente(int id, String RG, int CPF, String nome, String endereco, String profissao, String empresaEmpregadora) {
        this.id = id;
        this.RG = RG;
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
        this.empresaEmpregadora = empresaEmpregadora;
/*         this.rendimentos = rendimentos; */
    }

    @Override
    public int getId() {
        return this.id;
    }


    public void setId(int id) {
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

/*     public List<Float> getRendimentos() {
        return this.rendimentos;
    }

    public void setRendimentos(List<Float> rendimentos) {
        this.rendimentos = rendimentos;
    }

 */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && CPF == cliente.CPF && Objects.equals(nome, cliente.nome) && Objects.equals(endereco, cliente.endereco) && Objects.equals(profissao, cliente.profissao) && Objects.equals(empresaEmpregadora, cliente.empresaEmpregadora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CPF, nome, endereco, profissao, empresaEmpregadora);
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
