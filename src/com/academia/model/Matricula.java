package com.academia.model;

import java.time.LocalDate;
import java.util.Objects;

public class Matricula {

	private Long id;
	private final Long alunoId;
	private final Plano plano;
	private final LocalDate dataMatricula;
	private boolean ativa;

	public Matricula(Long id, Long alunoId, Plano plano, LocalDate dataMatricula) {
		this.id = id;
		this.alunoId = Objects.requireNonNull(alunoId, "O ID do aluno é obrigatório");
		this.plano = Objects.requireNonNull(plano, "O plano é obrigatório");
		this.dataMatricula = Objects.requireNonNull(dataMatricula, "A data da matrícula é obrigatória");
		this.ativa = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAlunoId() {
		return alunoId;
	}

	public Plano getPlano() {
		return plano;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void cancelar() {
		this.ativa = false;
	}
}
