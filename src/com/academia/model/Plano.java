package com.academia.model;

public abstract class Plano {

	private final String descricao;
	private final double valorMensal;
	private final int duracaoMeses;

	public Plano(String descricao, double valorMensal, int duracaoMeses) {
		this.descricao = descricao;
		this.valorMensal = valorMensal;
		this.duracaoMeses = duracaoMeses;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public int getDuracaoMeses() {
		return duracaoMeses;
	}

	public String getDescricao() {
		return descricao;
	}

	protected abstract double getPercentualDesconto();

	public abstract String getBeneficios();

	public double calcularValorTotal() {
		return valorMensal * duracaoMeses * (1 - getPercentualDesconto());
	}

}
