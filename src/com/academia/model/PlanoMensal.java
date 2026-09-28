package com.academia.model;

public class PlanoMensal extends Plano {

    public PlanoMensal() { super("Mensal", 150.0, 1);}

    @Override
    protected double getPercentualDesconto() {
        return AcademiaConfig.getInstance().getPercentualDescontoPlanoAnual();
    }

    @Override
    public String getBeneficios() {
        return "Acesso total + avaliação física";
    }
}
