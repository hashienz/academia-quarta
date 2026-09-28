package com.academia.repository;

import com.academia.model.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaRepository {

	Matricula salvar(Matricula matricula);

	Optional<Matricula> buscarPorId(Long id);

	List<Matricula> buscarTodos();

	List<Matricula> buscarPorAlunoId(Long alunoId);

	Optional<Matricula> buscarAtivaPorAlunoId(Long alunoId);

	boolean deletar(Long id);
}
