package com.academia.model;


 //Herda de Plano e define desconto de 5%.

public class PlanoTrimestral extends Plano {

    public PlanoTrimestral() {
        super("Trimestral", 130.0, 3);
    }

    @Override
    protected double getPercentualDesconto() {
        return 0.05; // 5% de desconto
    }

    @Override
    public String getBeneficios() {
        return "Acesso total + 1 avaliação física cortesia";
    }
}
