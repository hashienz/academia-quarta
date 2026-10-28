package com.academia.decorator;

import com.academia.model.Plano;

/**
 * [PADRÃO DE PROJETO: DECORATOR - ConcreteDecorator]
 * Adiciona o serviço de Personal Trainer a qualquer Plano.
 */
public class PersonalTrainerDecorator extends PlanoDecorator {

    private static final double CUSTO_MENSAL_ADICIONAL = 120.0;

    public PersonalTrainerDecorator(Plano planoDecorado) {
        super(planoDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Personal Trainer";
    }

    @Override
    public double getValorMensal() {
        return super.getValorMensal() + CUSTO_MENSAL_ADICIONAL;
    }

    @Override
    public String getBeneficios() {
        return super.getBeneficios() + " + Acompanhamento individual com Personal Trainer";
    }

    @Override
    public double calcularValorTotal() {
        return super.calcularValorTotal() + (CUSTO_MENSAL_ADICIONAL * getDuracaoMeses());
    }
}
