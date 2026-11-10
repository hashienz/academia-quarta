package com.academia.strategy;

import com.academia.model.Exercicio;

public class EstrategiaHipertrofia implements EstrategiaTreino {
    @Override
    public Exercicio prescreverExercicio(String nomeExercicio, String grupoMuscular) {
        return new Exercicio(null, nomeExercicio, grupoMuscular, 4, 10, 60);
    }
}
