package com.academia.decorator;

import com.academia.model.Plano;

import java.util.Objects;

/**
 * [PADRÃO DE PROJETO: DECORATOR]
 * Decorator base abstrato que envolve um objeto Plano existente,
 * permitindo adicionar responsabilidades (custos e benefícios extras)
 * dinamicamente sem alterar as classes concretas de Plano.
 */
public abstract class PlanoDecorator extends Plano {

    protected final Plano planoDecorado;

    public PlanoDecorator(Plano planoDecorado) {
        super(
                Objects.requireNonNull(planoDecorado, "O plano a ser decorado não pode ser nulo").getDescricao(),
                planoDecorado.getValorMensal(),
                planoDecorado.getDuracaoMeses()
        );
        this.planoDecorado = planoDecorado;
    }

    @Override
    public String getDescricao() {
        return planoDecorado.getDescricao();
    }

    @Override
    public double getValorMensal() {
        return planoDecorado.getValorMensal();
    }

    @Override
    public int getDuracaoMeses() {
        return planoDecorado.getDuracaoMeses();
    }

    @Override
    protected double getPercentualDesconto() {
        return 0.0;
    }

    @Override
    public String getBeneficios() {
        return planoDecorado.getBeneficios();
    }

    @Override
    public double calcularValorTotal() {
        return planoDecorado.calcularValorTotal();
    }
}
