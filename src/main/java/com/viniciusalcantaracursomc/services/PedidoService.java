package com.viniciusalcantaracursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusalcantaracursomc.domain.Cliente;
import com.viniciusalcantaracursomc.domain.Pedido;
import com.viniciusalcantaracursomc.domain.enums.EstadoPagamento;
import com.viniciusalcantaracursomc.repositories.PedidoRepository;
import com.viniciusalcantaracursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id:" +id+ "Tipo:" + Cliente.class.getName()
		));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().set
	}
}

