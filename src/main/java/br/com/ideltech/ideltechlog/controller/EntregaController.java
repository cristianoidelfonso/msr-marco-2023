package br.com.ideltech.ideltechlog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ideltech.ideltechlog.assembler.EntregaAssembler;
import br.com.ideltech.ideltechlog.dto.EntregaDTO;
import br.com.ideltech.ideltechlog.dto.input.EntregaInput;
import br.com.ideltech.ideltechlog.entity.Entrega;
import br.com.ideltech.ideltechlog.repository.EntregaRepository;
import br.com.ideltech.ideltechlog.service.impl.EntregaServiceImpl;
import br.com.ideltech.ideltechlog.service.impl.FinalizacaoEntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository entregaRepository;
	private EntregaServiceImpl entregaService;
	private EntregaAssembler entregaAssembler;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
	
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
	
		return entregaAssembler.toModel(entregaService.solicitar(novaEntrega));
	
	}
	
	@GetMapping
	public List<EntregaDTO> listar() {
		
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long id) {
		
		return entregaRepository.findById(id)
									.map((entrega) -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
									.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		
		finalizacaoEntregaService.finalizar(entregaId);
		
	}
	
}
