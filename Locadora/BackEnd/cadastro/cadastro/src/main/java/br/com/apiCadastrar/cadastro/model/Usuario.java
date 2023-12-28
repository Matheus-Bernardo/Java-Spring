package br.com.apiCadastrar.cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto incremento
    @Column(name="id")
    private int id;
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3,message = "O nome deve ter no minímo 3 caracteres")
    @Column(name="nome_completo",length = 200,nullable = false)
    private String nome;
    @Email(message = "Insira um email válido!")
    @NotBlank(message = "O email é obrigatório")
    @Column(name="email",length = 50,nullable = false)
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    @Column(name="senha",columnDefinition = "TEXT",nullable = false)
    private String senha;
    @NotBlank(message = "O telefone é obrigatório")
    @Column(name="telefone",length = 15,nullable = false)
    private String telefone;

    //getter and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}
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
