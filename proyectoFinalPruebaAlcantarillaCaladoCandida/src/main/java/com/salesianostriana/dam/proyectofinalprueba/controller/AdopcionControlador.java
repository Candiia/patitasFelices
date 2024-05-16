package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.service.AdopcionService;

@Controller
public class AdopcionControlador {
	
	@Autowired
	private AdopcionService adopcionService;		
	
	@GetMapping("/admin/listaAdopciones/")
	public String mostrarAdopciones(Model model) {
		model.addAttribute("adopciones", adopcionService.findAll());
		return "admin/listaAdopciones";
	}
	
	@GetMapping("/cliente/misAdopciones")
	public String mostrarAdopcionCliente(Model model, @AuthenticationPrincipal Cliente cliente) {
		model.addAttribute("adopCliente", cliente.getListaAdopcion());
		return "misAdopciones";
	}
	
	@GetMapping("/cliente/adoptar/{id}")
	public String adoptar(@AuthenticationPrincipal Cliente cliente, @PathVariable("id") Long id) {
		adopcionService.adoptarAnimal(cliente, id);
		return "redirect:/cliente/misAdopciones";
	}
	
	@GetMapping("/admin/eliminar/{idCliente}/{idAnimal}")
	public String eliminarAdopcion(@PathVariable("idCliente") Long idCliente,@PathVariable("idAnimal") Long idAnimal) {
		adopcionService.borrarAdopcion(idCliente,idAnimal);
		return "redirect:/admin/listaAdopciones/";
	}
}
