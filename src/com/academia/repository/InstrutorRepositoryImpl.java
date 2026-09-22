package com.academia.repository;

import com.academia.model.Instrutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InstrutorRepositoryImpl implements InstrutorRepository {

    private final Map<Long, Instrutor> database = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Instrutor salvar(Instrutor instrutor) {
        if (instrutor.getId() == null) {
            instrutor.setId(idGenerator.getAndIncrement());
        }
        database.put(instrutor.getId(), instrutor);
        return instrutor;
    }

    @Override
    public Optional<Instrutor> buscarPorId(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Instrutor> buscarTodos() {
        return new ArrayList<>(database.values());
    }

    @Override
    public boolean deletar(Long id) {
        return database.remove(id) != null;
    }

    @Override
    public Optional<Instrutor> buscarPorCref(String cref) {
        if (cref == null) {
            return Optional.empty();
        }
        return database.values().stream()
                .filter(i -> cref.equals(i.getCref()))
                .findFirst();
    }

    @Override
    public List<Instrutor> buscarPorEspecialidade(String especialidade) {
        if (especialidade == null) {
            return List.of();
        }
        return database.values().stream()
                .filter(i -> especialidade.equalsIgnoreCase(i.getEspecialidade()))
                .collect(Collectors.toList());
    }
}
