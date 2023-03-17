package br.com.ideltech.ideltechlog.service;

import java.util.List;

import br.com.ideltech.ideltechlog.entity.Cliente;
import br.com.ideltech.ideltechlog.entity.form.ClienteForm;


public interface IClienteService {
	
	Cliente create(ClienteForm form);

    Cliente getById(Long id);

    List<Cliente> getAll();

    Cliente update(Cliente cliente);

    void delete(Long clienteId);
    
    Cliente salvar(Cliente cliente);
    
    void excluir(Long clienteId);

}
