package com.algaworks;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.desconto.CalculadoraFaixaDesconto;

public class Pedido {

	private List<ItemPedido> itens = new ArrayList<>();

	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;

	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}

	public void validarQuantidadeItens(ItemPedido itemPedido) throws QuantidadeItensInvalidaException {
		if (itemPedido.getQuantidade() < 0) {
			throw new QuantidadeItensInvalidaException();
		}
	}

	public void adicionarItem(ItemPedido itemPedido) throws QuantidadeItensInvalidaException {
		validarQuantidadeItens(itemPedido);
		itens.add(itemPedido);
	}

	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.quantidade * i.valor).sum();
		double valorDesconto = calculadoraFaixaDesconto.desconto(valorTotal);

		return new ResumoPedido(valorTotal, valorDesconto);
	}

}
