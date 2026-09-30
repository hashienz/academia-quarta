package com.academia.model;

import java.time.LocalDate;

//HERANÇA / SOLID: LSP]//
public class Aluno extends Pessoa {

    private boolean matriculaAtiva;

    public Aluno(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
        super(id, nome, cpf, email, dataNascimento);
        this.matriculaAtiva = true;
    }

    public Aluno(Long id, String nome, String cpf, String email, LocalDate dataNascimento, boolean matriculaAtiva) {
        super(id, nome, cpf, email, dataNascimento);
        this.matriculaAtiva = matriculaAtiva;
    }

    public boolean isMatriculaAtiva() {
        return matriculaAtiva;
    }

    public void setMatriculaAtiva(boolean matriculaAtiva) {
        this.matriculaAtiva = matriculaAtiva;
    }

    @Override
    public String toString() {
        return "Aluno{id=" + getId() + ", nome='" + getNome() + "', cpf='" + getCpf() + "', ativa=" + matriculaAtiva + "}";
    }
}
