package com.academia.repository;

import com.academia.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementação em memória do repositório de alunos.
 * Utiliza ConcurrentHashMap para simular o banco de dados.
 */
public class AlunoRepositoryImpl implements AlunoRepository {

    private final Map<Long, Aluno> database = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Aluno salvar(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno é obrigatório");
        }
        if (aluno.getId() == null) {
            aluno.setId(idGenerator.getAndIncrement());
        }
        database.put(aluno.getId(), aluno);
        return aluno;
    }

    @Override
    public Optional<Aluno> buscarPorId(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Aluno> buscarTodos() {
        return new ArrayList<>(database.values());
    }

    @Override
    public boolean deletar(Long id) {
        return id != null && database.remove(id) != null;
    }

    @Override
    public Optional<Aluno> buscarPorCpf(String cpf) {
        if (cpf == null) {
            return Optional.empty();
        }
        return database.values().stream()
                .filter(aluno -> cpf.equals(aluno.getCpf()))
                .findFirst();
    }
}
