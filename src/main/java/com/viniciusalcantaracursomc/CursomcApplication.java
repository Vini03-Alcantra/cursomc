package com.viniciusalcantaracursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciusalcantaracursomc.domain.Categoria;
import com.viniciusalcantaracursomc.domain.Produto;
import com.viniciusalcantaracursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
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
	}
	
	
}
