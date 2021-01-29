package com.viniciusalcantaracursomc.domain;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	private Integer id;
	private String nome;
	private Double valor;
	
	private List<Categoria> categorias = new ArrayList();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
