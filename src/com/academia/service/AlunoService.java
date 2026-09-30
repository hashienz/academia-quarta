package com.academia.service;

import com.academia.exception.EntidadeNaoEncontradaException;
import com.academia.exception.RegraNegocioException;
import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;

import java.time.LocalDate;
import java.util.List;

 //[PRINCÍPIO SOLID: SRP & DIP]
 //Utiliza Injeção de Dependência via construtor para receber a interface do repositório.

public class AlunoService {

    private final AlunoRepository alunoRepository;

    // [INJEÇÃO DE DEPENDÊNCIA via construtor]
    public AlunoService(AlunoRepository alunoRepository) {
        if (alunoRepository == null) {
            throw new IllegalArgumentException("O repositório de alunos é obrigatório");
        }
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrar(String nome, String cpf, String email, LocalDate dataNascimento) {
        if (cpf != null && alunoRepository.buscarPorCpf(cpf).isPresent()) {
            throw new RegraNegocioException("Já existe um aluno cadastrado com o CPF: " + cpf);
        }
        Aluno aluno = new Aluno(null, nome, cpf, email, dataNascimento);
        return alunoRepository.salvar(aluno);
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Aluno não encontrado com ID: " + id));
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.buscarTodos();
    }

}
