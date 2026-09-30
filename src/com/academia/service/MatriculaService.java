package com.academia.service;

import com.academia.exception.EntidadeNaoEncontradaException;
import com.academia.exception.RegraNegocioException;
import com.academia.factory.PlanoFactory;
import com.academia.factory.TipoPlano;
import com.academia.model.Matricula;
import com.academia.repository.MatriculaRepository;

import java.time.LocalDate;
import java.util.List;


 //[PRINCÍPIO SOLID: SRP & DIP]
 //Utiliza Injeção de Dependência e o padrão Factory (PlanoFactory).

public class MatriculaService {

	// [INJEÇÃO DE DEPENDÊNCIA - DIP] Depende de abstração (Interface MatriculaRepository), não de classe concreta
	private final MatriculaRepository matriculaRepository;

	// Injeção via Construtor
	public MatriculaService(MatriculaRepository matriculaRepository) {
		if (matriculaRepository == null) {
			throw new IllegalArgumentException("O repositório de matrículas é obrigatório");
		}
		this.matriculaRepository = matriculaRepository;
	}

	public Matricula matricular(Long alunoId, TipoPlano tipoPlano) {
		if (alunoId == null || alunoId <= 0) {
			throw new RegraNegocioException("O ID do aluno deve ser positivo");
		}
		if (matriculaRepository.buscarAtivaPorAlunoId(alunoId).isPresent()) {
			throw new RegraNegocioException("O aluno já possui uma matrícula ativa");
		}

		// [USO DO FACTORY] A criação do objeto Plano é delegada ao PlanoFactory
		Matricula matricula = new Matricula(null, alunoId, PlanoFactory.criarPlano(tipoPlano), LocalDate.now());
		return matriculaRepository.salvar(matricula);
	}

	public Matricula buscarPorId(Long id) {
		return matriculaRepository.buscarPorId(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Matrícula não encontrada com ID: " + id));
	}

	public List<Matricula> listarTodos() {
		return matriculaRepository.buscarTodos();
	}

	public List<Matricula> listarPorAluno(Long alunoId) {
		return matriculaRepository.buscarPorAlunoId(alunoId);
	}

	public void cancelar(Long id) {
		Matricula matricula = buscarPorId(id);
		if (!matricula.isAtiva()) {
			throw new RegraNegocioException("A matrícula já está cancelada");
		}
		matricula.cancelar();
		matriculaRepository.salvar(matricula);
	}
}
