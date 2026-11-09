package com.academia.prototype;

/**
 * [PADRÃO DE PROJETO: PROTOTYPE]
 * Interface para objetos que sabem criar cópias de si mesmos,
 * permitindo gerar novas instâncias a partir de um modelo já configurado.
 */
public interface Prototype<T> {

    T clonar();
}
