package com.academia.repository;

import java.util.List;
import java.util.Optional;

/**
 * [PRINCÍPIO SOLID: ISP & DIP]
 * Interface genérica base para abstração do repositório (Data Access Layer).
 * Permite que os serviços dependam de abstrações, não de implementações concretas.
 */
public interface Repository<T, ID> {

    T salvar(T entity);

    Optional<T> buscarPorId(ID id);

    List<T> buscarTodos();

    boolean deletar(ID id);
}
