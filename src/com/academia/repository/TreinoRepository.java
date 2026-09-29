package com.academia.repository;

import com.academia.model.Treino;

import java.util.List;

/**
 * [PRINCÍPIO SOLID: ISP (Interface Segregation Principle)]
 * Interface específica para gestão de persistência de Treinos.
 */
public interface TreinoRepository extends Repository<Treino, Long> {

    List<Treino> buscarPorAlunoId(Long alunoId);

    List<Treino> buscarPorInstrutorId(Long instrutorId);
}