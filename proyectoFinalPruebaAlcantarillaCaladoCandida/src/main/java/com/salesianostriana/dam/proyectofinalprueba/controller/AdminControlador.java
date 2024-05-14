package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalprueba.model.Administrador;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Usuario;
import com.salesianostriana.dam.proyectofinalprueba.service.ClienteService;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	
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
		model.addAttribute("editar", true);
		return "/admin/formCliente";
	}
	
	@PostMapping("/agregarCliente/submit")
	public String submit(@ModelAttribute("cliente") Cliente cliente) {
		clienteServ.encriptarContraseya(cliente);
		clienteServ.save(cliente);
		return "redirect:/admin/listaCliente";
	}
	
	@GetMapping("/editarCliente/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
	
		if(clienteServ.findById(id).isPresent()) {
			model.addAttribute("cliente", clienteServ.findById(id).orElseThrow());
			model.addAttribute("editar", false);
			return "/admin/formCliente"; 
		}else {
			return"redirect:/admin/listaCliente";
		}
	}
	
	@PostMapping("/editarCliente/submit")
	public String procesarEditar(@ModelAttribute("cliente") Cliente cliente) {
		clienteServ.edit(cliente);
		return "redirect:/admin/listaCliente"; 
	}
	
	@GetMapping("/eliminarCliente/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		clienteServ.deleteById(id);
		return "redirect:/admin/listaCliente";
	} 
	
	@GetMapping("/perfilAdmin")
	public String perfilCliente(@AuthenticationPrincipal Administrador admin, Model model, Usuario usuario) {
		model.addAttribute("admin", admin);
		model.addAttribute("isAdmin", usuario.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return "perfil";
	}
	


}
