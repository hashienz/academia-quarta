package com.academia.factory;

import com.academia.exception.RegraNegocioException;
import com.academia.model.Plano;
import com.academia.model.PlanoAnual;
import com.academia.model.PlanoMensal;
import com.academia.model.PlanoTrimestral;
import com.academia.model.PlanoVip;

public final class PlanoFactory {

	private PlanoFactory() {
	}

	public static Plano criarPlano(TipoPlano tipoPlano) {
		if (tipoPlano == null) {
			throw new RegraNegocioException("O tipo de plano é obrigatório");
		}

		switch (tipoPlano) {
			case MENSAL:
				return new PlanoMensal();
			case TRIMESTRAL:
				return new PlanoTrimestral();
			case ANUAL:
				return new PlanoAnual();
			case VIP:
				return new PlanoVip();
			default:
				throw new RegraNegocioException("Tipo de plano inválido: " + tipoPlano);
		}
	}
}
