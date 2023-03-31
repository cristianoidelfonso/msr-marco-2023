package br.com.ideltech.ideltechlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ideltech.ideltechlog.assembler.OcorrenciaAssembler;
import br.com.ideltech.ideltechlog.dto.OcorrenciaDTO;
import br.com.ideltech.ideltechlog.dto.input.OcorrenciaInput;
import br.com.ideltech.ideltechlog.entity.Entrega;
import br.com.ideltech.ideltechlog.entity.Ocorrencia;
import br.com.ideltech.ideltechlog.service.impl.BuscaEntregaService;
import br.com.ideltech.ideltechlog.service.impl.RegistroOcorrenciaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;
	
	@Autowired
	private OcorrenciaAssembler ocorrenciaAssembler;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
		
	}
	
	@GetMapping
	@Transactional
	public List<OcorrenciaDTO> listar(@PathVariable Long entregaId ) {
	
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollectionDTO(entrega.getOcorrencias());
	
	}

	
	
}
