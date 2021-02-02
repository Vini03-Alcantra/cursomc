package com.viniciusalcantaracursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciusalcantaracursomc.domain.Categoria;
import com.viniciusalcantaracursomc.domain.Cidade;
import com.viniciusalcantaracursomc.domain.Cliente;
import com.viniciusalcantaracursomc.domain.Endereco;
import com.viniciusalcantaracursomc.domain.Estado;
import com.viniciusalcantaracursomc.domain.Produto;
import com.viniciusalcantaracursomc.domain.enums.TipoCliente;
import com.viniciusalcantaracursomc.repositories.CategoriaRepository;
import com.viniciusalcantaracursomc.repositories.CidadeRepository;
import com.viniciusalcantaracursomc.repositories.ClienteRepository;
import com.viniciusalcantaracursomc.repositories.EnderecoRepositorie;
import com.viniciusalcantaracursomc.repositories.EstadoRepository;
import com.viniciusalcantaracursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;	
	@Autowired
	private CidadeRepository cidadeRepository;	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepositorie enderecoRepositorie;
	
	@Autowired
	private ClienteRepository clienteRepositorie;
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
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente c1 = new Cliente(null, "Mariano Andrade", "mariano@email.com", "45645656790", TipoCliente.PESSOAFISICA);
		
		c1.getTelefones().addAll(Arrays.asList("949949494", "994903322"));
		
		Endereco e1 = new Endereco(null, "Rua Canadá", "34", "Apt 301", "Dutra", "94949", c1, cidade3);
		Endereco e2 = new Endereco(null, "Rua Jamaica", "32", "", "", "4005505", c1, cidade3);
		
		c1.getEnderecos().addAll(Arrays.asList(e1, e2));
	}
	
	
}
