package com.academia.strategy;

import com.academia.model.Exercicio;

public interface EstrategiaTreino {
    Exercicio prescreverExercicio(String nomeExercicio, String grupoMuscular);
}
