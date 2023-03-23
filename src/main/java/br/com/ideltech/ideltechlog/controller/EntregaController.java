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

import br.com.ideltech.ideltechlog.dto.DestinatarioDTO;
import br.com.ideltech.ideltechlog.dto.EntregaDTO;
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
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long id) {
		
		return entregaRepository.findById(id)
									.map((entrega) -> {
										EntregaDTO entregaDTO = new EntregaDTO();
										entregaDTO.setId(entrega.getId());
										entregaDTO.setNomeCliente(entrega.getCliente().getNome());
										
										entregaDTO.setDestinatario(new DestinatarioDTO());										
										entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
										entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
										entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
										entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
										entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
									
										entregaDTO.setTaxa(entrega.getTaxa());
										entregaDTO.setStatus(entrega.getStatus());
										entregaDTO.setDataPedido(entrega.getDataPedido());
										entregaDTO.setDataFinalizacao(entrega.getDataFinalizacao());
									
										
										return ResponseEntity.ok(entregaDTO);
									})
									.orElse(ResponseEntity.notFound().build());
		
	}
	
}
