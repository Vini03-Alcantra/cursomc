package com.viniciusalcantaracursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusalcantaracursomc.domain.Categoria;
import com.viniciusalcantaracursomc.domain.Produto;
import com.viniciusalcantaracursomc.dto.CategoriaDTO;
import com.viniciusalcantaracursomc.dto.ProdutoDTO;
import com.viniciusalcantaracursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id){
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage (
		@RequestParam(value="nome", defaultValue="") Integer nome,
		@RequestParam(value="categorias", defaultValue="0") Integer categorias,
		@RequestParam(value="page", defaultValue="0") Integer page,
		@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
		@RequestParam(value="orderBy", defaultValue="nome") String orderBy,
		@RequestParam(value="direction", defaultValue="ASC") String direction){
			Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
			Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
			return ResponseEntity.ok().body(listDto);
		}
	}
}
