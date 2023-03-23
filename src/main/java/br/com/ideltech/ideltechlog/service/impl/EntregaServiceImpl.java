package br.com.ideltech.ideltechlog.service.impl;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ideltech.ideltechlog.entity.Cliente;
import br.com.ideltech.ideltechlog.entity.Entrega;
import br.com.ideltech.ideltechlog.entity.StatusEntrega;
import br.com.ideltech.ideltechlog.repository.EntregaRepository;
import br.com.ideltech.ideltechlog.service.IEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntregaServiceImpl implements IEntregaService {
	
	private EntregaRepository entregaRepository;
	private ClienteServiceImpl clienteServiceImpl;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		Cliente cliente = clienteServiceImpl.findById(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
}
