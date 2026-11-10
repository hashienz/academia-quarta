package com.academia.observer;

/**
 * Contrato para componentes interessados em mudanças nas matrículas.
 */
public interface MatriculaObserver {

    void atualizar(MatriculaEvent evento);
}