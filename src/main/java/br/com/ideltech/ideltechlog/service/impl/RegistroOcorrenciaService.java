package br.com.ideltech.ideltechlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ideltech.ideltechlog.entity.Entrega;
import br.com.ideltech.ideltechlog.entity.Ocorrencia;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional 
	public Ocorrencia registrar(Long entregaId, String descricao) {
		
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	
	}
	
}
