package com.academia.repository;

import com.academia.model.Aluno;

import java.util.Optional;

/**
 * [PRINCÍPIO SOLID: ISP (Interface Segregation Principle)]
 * Interface específica para persistência de Aluno, herdando as operações CRUD genéricas.
 */
public interface AlunoRepository extends Repository<Aluno, Long> {

    Optional<Aluno> buscarPorCpf(String cpf);
}
