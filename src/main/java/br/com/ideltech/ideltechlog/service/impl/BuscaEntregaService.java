package br.com.ideltech.ideltechlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ideltech.ideltechlog.entity.Entrega;
import br.com.ideltech.ideltechlog.exception.EntidadeNaoEncontradaException;
import br.com.ideltech.ideltechlog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		
		return entregaRepository.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada."));
	
	}
	
}
