package br.com.softblue.bluefood.infraestructure.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.softblue.bluefood.application.ClienteService;
import br.com.softblue.bluefood.domain.cliente.Cliente;


import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/public")
public class PublicController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(path= "/cliente/new")
	public String CadastroCliente(Model model)
	{
		model.addAttribute("cliente", new Cliente());
		return "cliente-cadastro";
	}
	
	@PostMapping(path = "/cliente/save")
	public String saveCliente(@ModelAttribute("cliente") Cliente cliente)
	{
		clienteService.saveCliente(cliente);
		return "cliente-cadastro";
		
	}
	
	@GetMapping(path= "/restaurante/new")
	public String CadastroRestaurante()
	{
		return "restaurante-cadastro";
	}

}
