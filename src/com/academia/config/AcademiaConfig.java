package com.academia.config;

public class AcademiaConfig {

    private static AcademiaConfig instance;

    private String nomeAcademia;
    private int capacidadeMaximaAlunos;
    private double percentualDescontoPlanoAnual;
    private String horarioAbertura;
    private String horarioFechamento;

    private AcademiaConfig() {
        this.nomeAcademia = "Academia Quarta";
        this.capacidadeMaximaAlunos = 200;
        this.percentualDescontoPlanoAnual = 0.15;
        this.horarioAbertura = "06:00";
        this.horarioFechamento = "23:00";
    }

    public static synchronized AcademiaConfig getInstance() {
        if (instance == null) {
            instance = new AcademiaConfig();
        }
        return instance;
    }

    public String getNomeAcademia() {
        return nomeAcademia;
    }

    public void setNomeAcademia(String nomeAcademia) {
        this.nomeAcademia = nomeAcademia;
    }

    public int getCapacidadeMaximaAlunos() {
        return capacidadeMaximaAlunos;
    }

    public void setCapacidadeMaximaAlunos(int capacidadeMaximaAlunos) {
        this.capacidadeMaximaAlunos = capacidadeMaximaAlunos;
    }

    public double getPercentualDescontoPlanoAnual() {
        return percentualDescontoPlanoAnual;
    }

    public void setPercentualDescontoPlanoAnual(double percentualDescontoPlanoAnual) {
        this.percentualDescontoPlanoAnual = percentualDescontoPlanoAnual;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    @Override
    public String toString() {
        return "AcademiaConfig{" +
                "nomeAcademia='" + nomeAcademia + '\'' +
                ", capacidadeMaximaAlunos=" + capacidadeMaximaAlunos +
                ", percentualDescontoPlanoAnual=" + percentualDescontoPlanoAnual +
                ", horarioAbertura='" + horarioAbertura + '\'' +
                ", horarioFechamento='" + horarioFechamento + '\'' +
                '}';
    }
}
