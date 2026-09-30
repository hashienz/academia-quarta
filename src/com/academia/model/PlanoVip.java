package com.academia.model;

public class PlanoVip extends Plano {

    public PlanoVip() {
        super("VIP", 200.0, 12);
    }

    @Override
    protected double getPercentualDesconto() {
        return 0.20; // 20% de desconto
    }

    @Override
    public String getBeneficios() {
        return "Acesso VIP total, personal trainer dedicado e área de spa/recuperação";
    }
}
