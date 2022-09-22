package com.algaworks.desconto;

public class CalculadoraPrimeiraFaixa extends CalculadoraFaixaDesconto{

	public CalculadoraPrimeiraFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 300.0 && valorTotal < 800.0) 
			return valorTotal * 0.04;
		
		return -1;
	}
}
