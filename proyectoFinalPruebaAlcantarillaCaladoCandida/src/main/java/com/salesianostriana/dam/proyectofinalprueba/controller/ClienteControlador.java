package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.LineaVenta;
import com.salesianostriana.dam.proyectofinalprueba.model.Usuario;
import com.salesianostriana.dam.proyectofinalprueba.service.AnimalService;
import com.salesianostriana.dam.proyectofinalprueba.service.ClienteService;
import com.salesianostriana.dam.proyectofinalprueba.service.TipoAnimalService;
import com.salesianostriana.dam.proyectofinalprueba.service.VentaService;

@Controller
public class ClienteControlador {
	
	@Autowired
	private AnimalService animalServ;
	@Autowired
	private ClienteService clienteService;
	@Autowired 
	private TipoAnimalService tipoServ;
	@Autowired
	private VentaService ventaService;
	
	
	
	@GetMapping("/cliente/mostrarAnimales")
	public String listaAnimalAdopcion(Model model) {
		model.addAttribute("listaAnimales", animalServ.findAll());
		model.addAttribute("listaTipos", tipoServ.findAll());
		return "adoptar";
	} 
	
	@GetMapping("/cliente/mostrarAnimales/buscarAnimal")
	public String listaAnimalBuscar(Model model, @AuthenticationPrincipal Usuario usuario, @RequestParam("buscar") String buscar) {
		model.addAttribute("listaAnimales", animalServ.buscar(buscar));
		model.addAttribute("listaTipos", tipoServ.findAll());
		return "adoptar";
	} 

	@GetMapping("/cliente/mostrarAnimales/{id}")
	public String listaAnimalAdopcionPorTipo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("listaAnimales", animalServ.findByTipoAnimalId(id));
		model.addAttribute("listaTipos", tipoServ.findAll());
		return "adoptar";
	} 
	
	@GetMapping("/cliente/detalleAnimal")
	public String detalleAnimal(@RequestParam Long id,  Model model) {
		model.addAttribute("animal",  animalServ.buscarAnimalPorId(id));
		return "detalleAnimal";
	}
	
	@GetMapping("/cliente/perfilCliente")
	public String perfilCliente(@AuthenticationPrincipal Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		return "perfil";
	}
	
	@GetMapping("/registroCliente")
	public String agregarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("password", "password");
		return "registro";
	}
	
	@PostMapping("/registroCliente/submit")
	public String submit(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.save(cliente); 
		return "redirect:/paginaInicial";
	}
	
	@GetMapping("/cliente/misCompras")
	public String compras(@AuthenticationPrincipal Cliente cliente, Model model) {
		model.addAttribute("misCompras", cliente.getListaVenta());
		return "misCompras";
	}
	@GetMapping("/cliente/detalleVenta/{id}")
	public String detalleVenta(@PathVariable("id") Long id, Model model) {
		if(ventaService.findById(id).isPresent()) {
			List<LineaVenta> LineaVentaEncontrada = ventaService.findById(id).get().getLineasVentas();
			model.addAttribute("ventas", LineaVentaEncontrada);	
			return "detalleVenta";
		}
		return "redirect:/cliente/misCompras";
	}
}
