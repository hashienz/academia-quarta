package com.academia.decorator;

import com.academia.model.Plano;

/**
 * [PADRÃO DE PROJETO: DECORATOR - ConcreteDecorator]
 * Adiciona acesso livre à piscina aquecida e aulas de natação/hidroginástica ao Plano.
 */
public class AcessoPiscinaDecorator extends PlanoDecorator {

    private static final double CUSTO_MENSAL_ADICIONAL = 60.0;

    public AcessoPiscinaDecorator(Plano planoDecorado) {
        super(planoDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Acesso à Piscina";
    }

    @Override
    public double getValorMensal() {
        return super.getValorMensal() + CUSTO_MENSAL_ADICIONAL;
    }

    @Override
    public String getBeneficios() {
        return super.getBeneficios() + " + Acesso livre à piscina aquecida e hidroginástica";
    }

    @Override
    public double calcularValorTotal() {
        return super.calcularValorTotal() + (CUSTO_MENSAL_ADICIONAL * getDuracaoMeses());
    }
}
