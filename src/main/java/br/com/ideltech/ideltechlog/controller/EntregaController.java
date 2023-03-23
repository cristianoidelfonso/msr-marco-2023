package br.com.ideltech.ideltechlog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ideltech.ideltechlog.entity.Entrega;
import br.com.ideltech.ideltechlog.repository.EntregaRepository;
import br.com.ideltech.ideltechlog.service.impl.EntregaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository entregaRepository;
	private EntregaServiceImpl entregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		
		return entregaService.solicitar(entrega);
	
	}
	
	@GetMapping
	public List<Entrega> listar() {
		
		return entregaRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long id) {
		
		return entregaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	
}
