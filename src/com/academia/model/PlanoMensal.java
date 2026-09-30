package com.academia.model;

public class PlanoMensal extends Plano {

    public PlanoMensal() {
        super("Mensal", 150.0, 1);
    }

    @Override
    protected double getPercentualDesconto() {
        return 0.0; // Plano mensal padrão sem desconto
    }

    @Override
    public String getBeneficios() {
        return "Acesso à musculação e área cardio";
    }
}
