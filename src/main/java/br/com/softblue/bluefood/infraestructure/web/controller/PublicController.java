package br.com.softblue.bluefood.infraestructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.softblue.bluefood.domain.cliente.Cliente;

import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/public")
public class PublicController {
	
	@GetMapping(path= "/cliente/new")
	public String CadastroCliente(Model model)
	{
		model.addAttribute("cliente", new Cliente());
		return "cliente-cadastro";
	}
	
	@GetMapping(path= "/restaurante/new")
	public String CadastroRestaurante()
	{
		return "restaurante-cadastro";
	}

}
