package com.viniciusalcantaracursomc;

import java.text.SimpleDateFormat;
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
import com.viniciusalcantaracursomc.domain.ItemPedido;
import com.viniciusalcantaracursomc.domain.Pagamento;
import com.viniciusalcantaracursomc.domain.PagamentoComBoleto;
import com.viniciusalcantaracursomc.domain.PagamentoComCartao;
import com.viniciusalcantaracursomc.domain.Pedido;
import com.viniciusalcantaracursomc.domain.Produto;
import com.viniciusalcantaracursomc.domain.enums.EstadoPagamento;
import com.viniciusalcantaracursomc.domain.enums.TipoCliente;
import com.viniciusalcantaracursomc.repositories.CategoriaRepository;
import com.viniciusalcantaracursomc.repositories.CidadeRepository;
import com.viniciusalcantaracursomc.repositories.ClienteRepository;
import com.viniciusalcantaracursomc.repositories.EnderecoRepositorie;
import com.viniciusalcantaracursomc.repositories.EstadoRepository;
import com.viniciusalcantaracursomc.repositories.ItemPedidoRepository;
import com.viniciusalcantaracursomc.repositories.PagamentoRepository;
import com.viniciusalcantaracursomc.repositories.PedidoRepository;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama, mesa e banha");
		Categoria cat4 = new Categoria(null, "eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		
		Produto p1 = new Produto(null, "Impressora", 1000.00);
		Produto p2 = new Produto(null, "Mouse", 99.99);
		Produto p3 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p4 = new Produto(null, "Toalha", 50.00);
		Produto p5 = new Produto(null, "Colcha", 200.00);
		Produto p6 = new Produto(null, "Computador", 2000.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);		
				
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
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
		Endereco e2 = new Endereco(null, "Rua Jamaica", "32", "", "Machado", "4005505", c1, cidade3);
		
		c1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepositorie.saveAll(Arrays.asList(c1));
		
		enderecoRepositorie.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:01"), c1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("03/02/2019 23:41"), c1, e2);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/11/2018 13:40"), null);
		ped2.setPagamento(pag2);
		
		c1.getPedido().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 200.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 90.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 30.00, 3, 430.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
	
	
}
