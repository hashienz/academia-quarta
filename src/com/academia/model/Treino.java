package com.academia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade de domínio que associa um Aluno, um Instrutor e uma lista de Exercícios.
 */
public class Treino {

    private Long id;
    private String nomeTreino;
    private String objetivo;
    private Aluno aluno;
    private Instrutor instrutor;
    private List<Exercicio> exercicios;

    public Treino(Long id, String nomeTreino, String objetivo, Aluno aluno, Instrutor instrutor) {
        this.id = id;
        this.nomeTreino = nomeTreino;
        this.objetivo = objetivo;
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.exercicios = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }
}