package com.academia.model;

import java.time.LocalDate;

/**
 * [HERANÇA / SOLID: LSP]
 * Representa um Instrutor/Personal Trainer na academia.
 * Herda atributos de Pessoa e adiciona dados profissionais específicos (CREF, Especialidade).
 */
public class Instrutor extends Pessoa {

    private String especialidade;
    private String cref;
    private LocalDate dataContratacao;
    private boolean ativo;

    public Instrutor(Long id, String nome, String cpf, String email, LocalDate dataNascimento,
                     String especialidade, String cref, LocalDate dataContratacao) {
        super(id, nome, cpf, email, dataNascimento);
        this.especialidade = especialidade;
        this.cref = cref;
        this.dataContratacao = dataContratacao;
        this.ativo = true;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Instrutor{id=" + getId() + ", nome='" + getNome() + "', cref='" + cref + "', especialidade='" + especialidade + "'}";
    }
}
