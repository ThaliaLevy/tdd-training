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

	public void adicionarItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}
	
	/*	forma 01:
	public double calcularTotalPedido() {
			forma 01:
		    for (ItemPedido item : itens) { valorTotal += item.valor * item.quantidade; }
		  
		  	forma 02:
			return itens.stream().mapToDouble(i -> i.quantidade * i.valor).sum();
	}
	 
	 public double calcularDesconto() {
		double valorTotal = calcularTotalPedido();
		if(valorTotal > 300.0) {
			valorDesconto = valorTotal * 0.04;
		}
		return valorDesconto;
	}
	 
	 	forma 02:
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.quantidade * i.valor).sum();
		double valorDesconto = 0;
		
		if(valorTotal > 300.0 && valorTotal < 800.0) {
			valorDesconto = valorTotal * 0.04;
		} else if(valorTotal >= 800) {
				valorDesconto = valorTotal * 0.1;
		}
		return new ResumoPedido(valorTotal, valorDesconto);
	} 
		forma 03:
	*/
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.quantidade * i.valor).sum();
		double valorDesconto = calculadoraFaixaDesconto.desconto(valorTotal);
		
		return new ResumoPedido(valorTotal, valorDesconto);
	} 
	
}
