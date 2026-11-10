package com.academia.observer;

import com.academia.model.Matricula;

import java.util.Objects;

/**
 * Evento publicado quando uma matrícula é criada ou cancelada.
 */
public final class MatriculaEvent {

    public enum Tipo {
        MATRICULA_CRIADA,
        MATRICULA_CANCELADA
    }

    private final Tipo tipo;
    private final Matricula matricula;

    public MatriculaEvent(Tipo tipo, Matricula matricula) {
        this.tipo = Objects.requireNonNull(tipo, "O tipo do evento é obrigatório");
        this.matricula = Objects.requireNonNull(matricula, "A matrícula do evento é obrigatória");
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Matricula getMatricula() {
        return matricula;
    }
}