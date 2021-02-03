package com.viniciusalcantaracursomc.domain;

import com.viniciusalcantaracursomc.domain.enums.EstadoPagamento;

public class Pagamento {
	private Integer id;
	private EstadoPagamento estadoPagamento;
	
	
	public Pagamento() {}
	
	public Pagamento(Integer id, EstadoPagamento estadoPagamento) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EstadoPagamento getEstadoPagamento() {
		return estadoPagamento;
	}
	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}
	
	
}
