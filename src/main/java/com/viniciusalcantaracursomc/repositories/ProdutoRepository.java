package com.viniciusalcantaracursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciusalcantaracursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
}
