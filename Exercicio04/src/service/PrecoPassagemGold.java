package service;

import model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		if (voo.getPreco() > 500) {
			return calcularPrecoAcimaDoLimite(voo);
		}
		return calcularPrecoAbaixoDoLimite(voo);

	}

	public double calcularPrecoAcimaDoLimite(Voo voo) {
		return voo.getPreco() * 0.85;
	}

	public double calcularPrecoAbaixoDoLimite(Voo voo) {
		return voo.getPreco() * 0.9;
	}
}
