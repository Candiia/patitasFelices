package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Usuario;
import com.salesianostriana.dam.proyectofinalprueba.service.ClienteService;

@Controller
@RequestMapping("/user")
public class ClienteControlador {
	
	@Autowired
	private ClienteService clienteServ;
	
	@GetMapping("/listaCliente")
	public String mostrarClientes(Model model) {
		model.addAttribute("listaCliente", clienteServ.findAll());
		return "/admin/listaClientes";
	}
	
	@GetMapping("/agregarCliente")
	public String agregarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "/admin/formCliente";
	}
	
	@PostMapping("/agregarCliente/submit")
	public String submit(@ModelAttribute("cliente") Cliente cliente) {
		clienteServ.save(cliente);
		return "redirect:/admin/listaCliente";
	}
	
	

	@GetMapping("/me")
	public String me() {

		Cliente c = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(c.toString());

		return "perfil";
	}

	@GetMapping("/me2")
	public String me2(@AuthenticationPrincipal Cliente c) {

		System.out.println(c.toString());

		return "perfil";
	}
	
}
