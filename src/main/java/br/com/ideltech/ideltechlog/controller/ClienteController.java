package br.com.ideltech.ideltechlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ideltech.ideltechlog.entity.Cliente;
import br.com.ideltech.ideltechlog.entity.form.ClienteForm;
import br.com.ideltech.ideltechlog.repository.ClienteRepository;
import br.com.ideltech.ideltechlog.service.impl.ClienteServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl service;
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = service.getAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
	
	@GetMapping("/{id}") 
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
//		Cliente cliente = service.getById(id);
//		return new ResponseEntity<>(cliente, HttpStatus.OK);
		
		/** Modo 3 */
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
		/** Modo 2 */
//		return repository.findById(id)
//				.map(cliente -> ResponseEntity.ok(cliente))
//				.orElse(ResponseEntity.notFound().build());

		/** Modo 1 */
//		Optional<Cliente> cliente = repository.findById(id);
//		if(cliente.isPresent()) {			
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteForm formCliente) {
        Cliente savedCliente = service.create(formCliente);
        return new ResponseEntity<Cliente>(savedCliente, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente = service.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}

	
	
}
