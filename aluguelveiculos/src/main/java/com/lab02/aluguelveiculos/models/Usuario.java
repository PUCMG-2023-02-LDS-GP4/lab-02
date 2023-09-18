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
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String telefone;

    @Column
    private String endereco;

    @Column(nullable = false)
    private String senha;

    @OneToMany 
    private List<Pedidos> pedidosCliente = new ArrayList<>();


    public Usuario() {
    }

    public Usuario(int id, String username, String email, String telefone, String endereco, String senha, List<Pedidos> pedidosCliente) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha;
        this.pedidosCliente = pedidosCliente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Pedidos> getPedidosCliente() {
        return this.pedidosCliente;
    }

    public void setPedidosCliente(List<Pedidos> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(username, usuario.username) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) && Objects.equals(endereco, usuario.endereco) && Objects.equals(senha, usuario.senha) && Objects.equals(pedidosCliente, usuario.pedidosCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, telefone, endereco, senha, pedidosCliente);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", senha='" + getSenha() + "'" +
            ", pedidosCliente='" + getPedidosCliente() + "'" +
            "}";
    }

    public void cadastrarUsuario(String username, String email, String telefone, String senha) {

    }

    public String consultarPedido(int idPedido) {

    }

    public String modificarPedido(int idPedido) {

    }

    public void cancelarPedido(int idPedido) {

    }
}
