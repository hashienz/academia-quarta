package com.academia.repository;

import com.academia.model.Instrutor;

import java.util.List;
import java.util.Optional;

public interface InstrutorRepository extends Repository<Instrutor, Long> {

    Optional<Instrutor> buscarPorCref(String cref);

    List<Instrutor> buscarPorEspecialidade(String especialidade);
}
