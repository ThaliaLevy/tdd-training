package service;

import model.Passageiro;
import model.Voo;

public class PrecoPassagemService {

	public double calcularValorPassagem(Passageiro passageiro, Voo voo) {

		return passageiro.getTipo().getCalculadora().calcular(voo);
	}
}
