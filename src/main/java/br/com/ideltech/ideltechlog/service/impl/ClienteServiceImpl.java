package br.com.ideltech.ideltechlog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ideltech.ideltechlog.entity.Cliente;
import br.com.ideltech.ideltechlog.entity.form.ClienteForm;
import br.com.ideltech.ideltechlog.exception.NegocioException;
import br.com.ideltech.ideltechlog.repository.ClienteRepository;
import br.com.ideltech.ideltechlog.service.IClienteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {
	
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Long id) {
		
		return clienteRepository.findById(id).orElseThrow(() -> new NegocioException("Cliente não localizado."));
	}

	@Override
	public Cliente create(ClienteForm form) {		
		Cliente cliente =  new Cliente(null, form.getNome(), form.getEmail(), form.getTelefone());
		boolean emailEmUso = clienteRepository.findByEmail(form.getEmail()).stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Este email já está em uso.");
		}
		
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente getById(Long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente update(Cliente cliente) {
		Cliente existingCliente = clienteRepository.findById(cliente.getId()).get();
		existingCliente.setNome(cliente.getNome());
		existingCliente.setEmail(cliente.getEmail());
		existingCliente.setTelefone(cliente.getTelefone());
        Cliente updatedCliente = clienteRepository.save(existingCliente);
		
        return updatedCliente;
	}

	@Override
	public void delete(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

	
	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Override
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	


}
