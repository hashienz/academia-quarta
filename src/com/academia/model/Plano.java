package com.academia.model;

/**
 * [PRINCÍPIO SOLID: OCP (Open/Closed Principle) & TEMPLATE METHOD]
 * Classe abstrata base. O sistema está aberto para extensão (novos tipos de planos)
 * mas fechado para modificação (o método de cálculo total permanece inalterado).
 */
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

	// Método polimórfico implementado por cada plano concreto
	protected abstract double getPercentualDesconto();

	public abstract String getBeneficios();

	// [TEMPLATE METHOD / OCP] Algoritmo comum que utiliza o desconto específico de cada subclasse
	public double calcularValorTotal() {
		return valorMensal * duracaoMeses * (1 - getPercentualDesconto());
	}
}
