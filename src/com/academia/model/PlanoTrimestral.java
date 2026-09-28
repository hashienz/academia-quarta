package com.academia.model;

public class PlanoTrimestral extends Plano {

    public PlanoTrimestral() {
        super("Trimestral", 125.0, 3);
    }

    @Override
    protected double getPercentualDesconto() {
        return AcademiaConfig.getInstance().getPercentualDescontoPlanoAnual();
    }

    @Override
    public String getBeneficios() {
        return "Acesso total + avaliação física";
    }
}
