package com.academia.repository;

import com.academia.model.Matricula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class MatriculaRepositoryImpl implements MatriculaRepository {

	private final Map<Long, Matricula> database = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(1);

	@Override
	public Matricula salvar(Matricula matricula) {
		if (matricula == null) {
			throw new IllegalArgumentException("A matrícula é obrigatória");
		}
		if (matricula.getId() == null) {
			matricula.setId(idGenerator.getAndIncrement());
		}
		database.put(matricula.getId(), matricula);
		return matricula;
	}

	@Override
	public Optional<Matricula> buscarPorId(Long id) {
		return id == null ? Optional.empty() : Optional.ofNullable(database.get(id));
	}

	@Override
	public List<Matricula> buscarTodos() {
		return new ArrayList<>(database.values());
	}

	@Override
	public List<Matricula> buscarPorAlunoId(Long alunoId) {
		if (alunoId == null) {
			return List.of();
		}
		return database.values().stream()
				.filter(matricula -> alunoId.equals(matricula.getAlunoId()))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Matricula> buscarAtivaPorAlunoId(Long alunoId) {
		if (alunoId == null) {
			return Optional.empty();
		}
		return database.values().stream()
				.filter(matricula -> matricula.isAtiva() && alunoId.equals(matricula.getAlunoId()))
				.findFirst();
	}

	@Override
	public boolean deletar(Long id) {
		return id != null && database.remove(id) != null;
	}
}
