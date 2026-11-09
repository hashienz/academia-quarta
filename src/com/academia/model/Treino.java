package com.academia.model;

import com.academia.prototype.Prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade de domínio que associa um Aluno, um Instrutor e uma lista de Exercícios.
 *
 * [PADRÃO DE PROJETO: PROTOTYPE]
 * Um treino já montado pode ser clonado para servir de base a outro aluno,
 * sem precisar cadastrar novamente cada exercício.
 */
public class Treino implements Prototype<Treino> {

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

    // Construtor de cópia: id e aluno ficam nulos, pois o clone pertencerá a outro aluno
    private Treino(Treino origem) {
        this(null, origem.nomeTreino, origem.objetivo, null, origem.instrutor);
        for (Exercicio exercicio : origem.exercicios) {
            this.exercicios.add(exercicio.clonar()); // cópia profunda: o clone não compartilha exercícios com o original
        }
    }

    @Override
    public Treino clonar() {
        return new Treino(this);
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

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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