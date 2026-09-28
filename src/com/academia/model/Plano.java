package com.academia.model;

public abstract class Plano {

	private final String descricao;

	protected Plano(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
