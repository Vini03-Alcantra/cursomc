package com.viniciusalcantaracursomc.domain;

public class ItemPedido {
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {}
	
	public ItemPedido(Double desconto, Integer quantidade, Double preco) {
		super();
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
