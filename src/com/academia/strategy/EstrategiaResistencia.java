package com.academia.strategy;

import com.academia.model.Exercicio;

public class EstrategiaResistencia implements EstrategiaTreino {
    @Override
    public Exercicio prescreverExercicio(String nomeExercicio, String grupoMuscular) {
        return new Exercicio(null, nomeExercicio, grupoMuscular, 3, 15, 30);
    }
}
