package com.algaworks.desconto;

public class CalculadoraDescontoSegundaFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDescontoSegundaFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if (valorTotal >= 800)
			return valorTotal * 0.1;
		
		return -1;
	}
}
