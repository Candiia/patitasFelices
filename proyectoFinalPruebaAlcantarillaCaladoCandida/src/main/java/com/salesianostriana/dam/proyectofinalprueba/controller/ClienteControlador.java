package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalprueba.service.ClienteService;

@Controller
@RequestMapping("/admin")
public class ClienteControlador {
	
	@Autowired
	private ClienteService clienteServ;
	
	@GetMapping("/listaCliente")
	public String mostrarClientes(Model model) {
		model.addAttribute("listaCliente", clienteServ.findAll());
		return "/admin/listaClientes";
	}
	
	
}
