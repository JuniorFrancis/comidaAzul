package br.com.softblue.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softblue.bluefood.domain.cliente.ClienteRepository;
import br.com.softblue.bluefood.domain.cliente.Cliente;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;
	
	public void saveCliente(Cliente cliente) {
		
		clienteRepository.save(cliente);
		
	}
	
}
