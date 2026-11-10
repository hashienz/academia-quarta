package com.academia.repository;

import com.academia.model.Treino;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class TreinoRepositoryImpl implements TreinoRepository {
    private final Map<Long, Treino> database = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Treino salvar(Treino treino) {
        if (treino == null) {
            throw new IllegalArgumentException("O treino é obrigatório");
        }
        if (treino.getId() == null) {
            treino.setId(idGenerator.getAndIncrement());
        }
        database.put(treino.getId(), treino);
        return treino;
    }

    @Override
    public Optional<Treino> buscarPorId(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Treino> buscarTodos() {
        return new ArrayList<>(database.values());
    }

    @Override
    public boolean deletar(Long id) {
        return id != null && database.remove(id) != null;
    }

    @Override
    public List<Treino> buscarPorAlunoId(Long alunoId) {
        if (alunoId == null) return List.of();
        return database.values().stream()
                .filter(t -> t.getAluno() != null && alunoId.equals(t.getAluno().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Treino> buscarPorInstrutorId(Long instrutorId) {
        if (instrutorId == null) return List.of();
        return database.values().stream()
                .filter(t -> t.getInstrutor() != null && instrutorId.equals(t.getInstrutor().getId()))
                .collect(Collectors.toList());
    }
}