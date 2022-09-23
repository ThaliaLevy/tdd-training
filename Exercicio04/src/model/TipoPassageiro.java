package model;

import service.CalculadoraPrecoPassagem;
import service.PrecoPassagemGold;
import service.PrecoPassagemSilver;

public enum TipoPassageiro {
	GOLD(new PrecoPassagemGold()), SILVER(new PrecoPassagemSilver());

	CalculadoraPrecoPassagem calculadoraPrecoPassagem;

	TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
		this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
	}

	public CalculadoraPrecoPassagem getCalculadora() {
		return calculadoraPrecoPassagem;
	}

}
