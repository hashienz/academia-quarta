package com.academia.model;

public class PlanoAnual extends Plano {

    public PlanoAnual() {
        super("Anual", 100.0, 12);
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
