package com.academia.repository;

import com.academia.model.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaRepository extends Repository<Matricula, Long> {

	List<Matricula> buscarPorAlunoId(Long alunoId);

	Optional<Matricula> buscarAtivaPorAlunoId(Long alunoId);

}
