package com.academia.model;

import java.time.LocalDate;

/**
 * [PRINCÍPIO SOLID: LSP (Liskov Substitution Principle)]
 * Classe abstrata base que representa uma pessoa no sistema.
 * Subclasses (Aluno, Instrutor) podem substituir a superclasse em qualquer ponto do código.
 */
public abstract class Pessoa {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;

    public Pessoa(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
