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
import com.salesianostriana.dam.proyectofinalprueba.service.VentaService;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	
	@Autowired
	private ClienteService clienteServ;
	@Autowired
	private VentaService  ventaService;
		
	@GetMapping("/listaCliente/")
	public String mostrarClientes(Model model) {
		model.addAttribute("listaCliente", clienteServ.findAll());
		return "/admin/listaClientes";
	}

	@GetMapping("/agregarCliente")
	public String agregarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("editar", true);
		model.addAttribute("password", "password");
		return "/admin/formCliente";
	}
	
	@PostMapping("/agregarCliente/submit")
	public String submit(@ModelAttribute("cliente") Cliente cliente) {
		clienteServ.save(cliente); 
		return "redirect:/admin/listaCliente/";
	}
	
	@GetMapping("/editarCliente/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
	
		if(clienteServ.findById(id).isPresent()) {
			model.addAttribute("cliente", clienteServ.buscarClientePorId(id));
			model.addAttribute("editar", false);
			model.addAttribute("password", "hidden");
			return "/admin/formCliente"; 
		}else {
			return"redirect:/admin/listaCliente/";
		}
	}
	
	@PostMapping("/editarCliente/submit")
	public String procesarEditar(@ModelAttribute("cliente") Cliente cliente) {
		clienteServ.edit(cliente);
		return "redirect:/admin/listaCliente/"; 
	}
	
	@GetMapping("/eliminarCliente/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		Cliente cliente = clienteServ.buscarClientePorId(id);
		if(cliente != null) {
			if(clienteServ.numVentasCliente(cliente) == 0 && clienteServ.numAdopcionCliente(cliente) == 0) {
				clienteServ.deleteById(id);
			}else {
				return "redirect:/admin/listaCliente/?error=true";
			}
		}
		return "redirect:/admin/listaCliente/";
	} 
	
	@GetMapping("/perfilAdmin")
	public String perfilCliente(@AuthenticationPrincipal Administrador admin, Model model, Usuario usuario) {
		model.addAttribute("admin", admin);
		model.addAttribute("isAdmin", usuario.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return "perfil";
	}
	
	@GetMapping("/ventasRealizadas")
	public String ventasRealizas(Model model) {
		model.addAttribute("ventas", ventaService.findAll());
		return "/admin/ventasRealizadas";
	}


}
