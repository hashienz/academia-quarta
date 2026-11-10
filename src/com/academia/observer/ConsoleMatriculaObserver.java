package com.academia.observer;

import com.academia.model.Matricula;

/**
 * Observador de demonstração que registra eventos de matrícula no console.
 */
public final class ConsoleMatriculaObserver implements MatriculaObserver {

    @Override
    public void atualizar(MatriculaEvent evento) {
        Matricula matricula = evento.getMatricula();
        String acao;

        switch (evento.getTipo()) {
            case MATRICULA_CRIADA:
                acao = "criada";
                break;
            case MATRICULA_CANCELADA:
                acao = "cancelada";
                break;
            default:
                throw new IllegalStateException("Tipo de evento de matricula desconhecido");
        }

        System.out.println("[OBSERVADOR] Matrícula " + acao
                + " | ID: " + matricula.getId()
                + " | Aluno: " + matricula.getAlunoId()
                + " | Plano: " + matricula.getPlano().getDescricao());
    }
}