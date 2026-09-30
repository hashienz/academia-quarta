package com.academia.factory;

import com.academia.exception.RegraNegocioException;
import com.academia.model.Plano;
import com.academia.model.PlanoAnual;
import com.academia.model.PlanoMensal;
import com.academia.model.PlanoTrimestral;
import com.academia.model.PlanoVip;

/**
 * Factory Method: cada criador concreto implementa criar() para produzir um Plano.
 * criarPlano(TipoPlano) mantém um ponto de entrada simples para os serviços.
 */
public abstract class PlanoFactory {

	protected abstract Plano criar();

	public static Plano criarPlano(TipoPlano tipoPlano) {
		if (tipoPlano == null) {
			throw new RegraNegocioException("O tipo de plano é obrigatório");
		}

		PlanoFactory factory;
		switch (tipoPlano) {
			case MENSAL:
				factory = new MensalFactory();
				break;
			case TRIMESTRAL:
				factory = new TrimestralFactory();
				break;
			case ANUAL:
				factory = new AnualFactory();
				break;
			case VIP:
				factory = new VipFactory();
				break;
			default:
				throw new RegraNegocioException("Tipo de plano inválido: " + tipoPlano);
		}
		return factory.criar();
	}

	private static final class MensalFactory extends PlanoFactory {
		@Override
		protected Plano criar() { return new PlanoMensal(); }
	}

	private static final class TrimestralFactory extends PlanoFactory {
		@Override
		protected Plano criar() { return new PlanoTrimestral(); }
	}

	private static final class AnualFactory extends PlanoFactory {
		@Override
		protected Plano criar() { return new PlanoAnual(); }
	}

	private static final class VipFactory extends PlanoFactory {
		@Override
		protected Plano criar() { return new PlanoVip(); }
	}
}
