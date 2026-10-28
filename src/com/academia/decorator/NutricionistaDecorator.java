package com.academia.decorator;

import com.academia.model.Plano;

/**
 * [PADRÃO DE PROJETO: DECORATOR - ConcreteDecorator]
 * Adiciona acompanhamento com nutricionista esportivo ao Plano.
 */
public class NutricionistaDecorator extends PlanoDecorator {

    private static final double CUSTO_MENSAL_ADICIONAL = 80.0;

    public NutricionistaDecorator(Plano planoDecorado) {
        super(planoDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Nutricionista";
    }

    @Override
    public double getValorMensal() {
        return super.getValorMensal() + CUSTO_MENSAL_ADICIONAL;
    }

    @Override
    public String getBeneficios() {
        return super.getBeneficios() + " + Consultas mensais com Nutricionista Esportivo";
    }

    @Override
    public double calcularValorTotal() {
        return super.calcularValorTotal() + (CUSTO_MENSAL_ADICIONAL * getDuracaoMeses());
    }
}
