package com.algaworks;

public class ItemPedido {
	public String nomeProduto;
	public double valor;
	public int quantidade;

	public ItemPedido(String nomeProduto, double valor, int quantidade) {
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}