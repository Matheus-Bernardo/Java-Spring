package br.com.apiCadastrar.cadastro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto incremento
    @Column(name="id")
    private int id;
    @Column(name="nome_completo",length = 200,nullable = true)
    private String nome;
    @Column(name="email",length = 50,nullable = true)
    private String email;
    @Column(name="senha",columnDefinition = "TEXT",nullable = true)
    private String senha;
    @Column(name="telefone",length = 15,nullable = true)
    private String telefone;

    //getter and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
