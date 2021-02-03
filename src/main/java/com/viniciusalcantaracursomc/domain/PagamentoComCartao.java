package com.viniciusalcantaracursomc.domain;

public class PagamentoComCartao {
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {}
	
	public PagamentoComCartao(Integer numeroDeParcelas) {
		super();
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
