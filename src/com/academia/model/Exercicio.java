package com.academia.model;

import com.academia.prototype.Prototype;

import java.util.concurrent.atomic.AtomicLong;

public class Exercicio implements Prototype<Exercicio> {

    private static final AtomicLong ID_GERADOR = new AtomicLong(1);

    private Long id;
    private String nome;
    private String grupoMuscular;
    private int series;
    private int repeticoes;
    private int descansoSegundos;

    public Exercicio(Long id, String nome, String grupoMuscular, int series, int repeticoes, int descansoSegundos) {
        if (id == null) {
            this.id = ID_GERADOR.getAndIncrement();
        } else {
            this.id = id;
            if (id >= 0 && id < Long.MAX_VALUE) {
                ID_GERADOR.accumulateAndGet(id + 1, Math::max);
            }
        }
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticoes = repeticoes;
        this.descansoSegundos = descansoSegundos;
    }

    @Override
    public Exercicio clonar() {
        return new Exercicio(null, nome, grupoMuscular, series, repeticoes, descansoSegundos);
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public int getDescansoSegundos() {
        return descansoSegundos;
    }

    @Override
    public String toString() {
        return nome + " [" + grupoMuscular + "] - " + series + "x" + repeticoes + " (Descanso: " + descansoSegundos + "s)";
    }
}