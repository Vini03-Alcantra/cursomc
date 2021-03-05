package com.viniciusalcantaracursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.viniciusalcantaracursomc.domain.Produto;
import com.viniciusalcantaracursomc.domain.Categoria;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome") String name, @Param("categorias")List<Categoria> categorias, Pageable pageRequest);	
}
