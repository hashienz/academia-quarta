package com.academia.service;

import com.academia.exception.EntidadeNaoEncontradaException;
import com.academia.exception.RegraNegocioException;
import com.academia.model.Instrutor;
import com.academia.repository.InstrutorRepository;

import java.time.LocalDate;
import java.util.List;

public class InstrutorService {

    private final InstrutorRepository instrutorRepository;

    public InstrutorService(InstrutorRepository instrutorRepository) {
        this.instrutorRepository = instrutorRepository;
    }

    public Instrutor cadastrar(String nome, String cpf, String email, LocalDate dataNascimento,
                                String especialidade, String cref, LocalDate dataContratacao) {
        if (cref != null && instrutorRepository.buscarPorCref(cref).isPresent()) {
            throw new RegraNegocioException("Já existe um instrutor cadastrado com o CREF: " + cref);
        }

        Instrutor instrutor = new Instrutor(null, nome, cpf, email, dataNascimento,
                especialidade, cref, dataContratacao);
        return instrutorRepository.salvar(instrutor);
    }

    public Instrutor buscarPorId(Long id) {
        return instrutorRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Instrutor não encontrado com ID: " + id));
    }

    public List<Instrutor> listarTodos() {
        return instrutorRepository.buscarTodos();
    }

    public List<Instrutor> listarPorEspecialidade(String especialidade) {
        return instrutorRepository.buscarPorEspecialidade(especialidade);
    }

    public Instrutor atualizar(Long id, String nome, String email, String especialidade) {
        Instrutor instrutor = buscarPorId(id);
        instrutor.setNome(nome);
        instrutor.setEmail(email);
        instrutor.setEspecialidade(especialidade);
        return instrutorRepository.salvar(instrutor);
    }

    public void desativar(Long id) {
        Instrutor instrutor = buscarPorId(id);
        instrutor.setAtivo(false);
        instrutorRepository.salvar(instrutor);
    }

    public void ativar(Long id) {
        Instrutor instrutor = buscarPorId(id);
        instrutor.setAtivo(true);
        instrutorRepository.salvar(instrutor);
    }

    public void remover(Long id) {
        buscarPorId(id);
        instrutorRepository.deletar(id);
    }
}
