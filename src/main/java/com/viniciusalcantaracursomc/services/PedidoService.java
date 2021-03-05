package com.viniciusalcantaracursomc.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusalcantaracursomc.domain.Cliente;
import com.viniciusalcantaracursomc.domain.ItemPedido;
import com.viniciusalcantaracursomc.domain.PagamentoComBoleto;
import com.viniciusalcantaracursomc.domain.Pedido;
import com.viniciusalcantaracursomc.domain.enums.EstadoPagamento;
import com.viniciusalcantaracursomc.repositories.ItemPedidoRepository;
import com.viniciusalcantaracursomc.repositories.PagamentoRepository;
import com.viniciusalcantaracursomc.repositories.PedidoRepository;
import com.viniciusalcantaracursomc.repositories.ProdutoRepository;
import com.viniciusalcantaracursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id:" + id + "Tipo:" + Cliente.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);

		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);			
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getpreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
}
