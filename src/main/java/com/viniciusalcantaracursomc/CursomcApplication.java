package com.viniciusalcantaracursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciusalcantaracursomc.domain.Categoria;
import com.viniciusalcantaracursomc.domain.Cidade;
import com.viniciusalcantaracursomc.domain.Estado;
import com.viniciusalcantaracursomc.domain.Produto;
import com.viniciusalcantaracursomc.repositories.CategoriaRepository;
import com.viniciusalcantaracursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Sistemas de Infromação");
		Categoria cat2 = new Categoria(null, "Engenharia da Computação");
		
		Produto p1 = new Produto(null, "PC Lenovo", 2000.00);
		Produto p2 = new Produto(null, "PC Acer", 1899.99);
		Produto p3 = new Produto(null, "PC Sansumg", 2300.50);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Santa Catarina");
		
		Cidade cidade1 = new Cidade(null, "Blumenau", est1);
		Cidade cidade2 = new Cidade(null, "Ouro Preto", est2);
		Cidade cidade3 = new Cidade(null, "Joinvile", est1);
		
		est1.getCidades().addAll(Arrays.asList(cidade2));
		est2.getCidades().addAll(Arrays.asList(cidade1, cidade3));
	}
	
	
}
