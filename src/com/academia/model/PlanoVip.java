package com.academia.model;

public class PlanoVip extends Plano {

    public PlanoVip() {
        super("VIP", 200.0, 24);
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
