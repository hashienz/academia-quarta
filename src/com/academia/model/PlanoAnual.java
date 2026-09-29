package com.academia.model;

import com.academia.config.AcademiaConfig;

/**
 * Subclasse concreta representando o Plano Anual.
 * Obtém a taxa de desconto centralizada a partir da configuração da academia (Singleton).
 */
public class PlanoAnual extends Plano {

    public PlanoAnual() {
        super("Anual", 100.0, 12);
    }

    @Override
    protected double getPercentualDesconto() {
        // Busca a taxa de desconto no Singleton de Configuração
        return AcademiaConfig.getInstance().getPercentualDescontoPlanoAnual();
    }

    @Override
    public String getBeneficios() {
        return "Acesso total + avaliações físicas trimestrais + armário exclusivo";
    }
}
