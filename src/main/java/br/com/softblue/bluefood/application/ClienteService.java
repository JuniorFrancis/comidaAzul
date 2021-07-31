package br.com.softblue.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softblue.bluefood.domain.cliente.ClienteRepository;
import br.com.softblue.bluefood.domain.cliente.Cliente;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;
	
	public void saveCliente(Cliente cliente) throws ValidationException {
		
		if(!validateEmail(cliente.getEmail(), cliente.getId()))
		{
			throw new ValidationException("Já existe um e-mail igual a este cadastrado!");
		}
		
		if(cliente.id != null){
			Cliente clienteDB = clienteRepository.findById(cliente.getId()).orElseThrow();
			cliente.setSenha(clienteDB.getSenha());
		}else{
			cliente.encryptPassword();
		}
		
		clienteRepository.save(cliente);
		
	}
	
	private boolean validateEmail(String email, Integer id)
	{
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente != null)
		{
			if(id == null)
			{
				return false;
			} 
			
			if(!cliente.getId().equals(id))
			{
				return false;
			}
		}
		return true;
	}
	
}
