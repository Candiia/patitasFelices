package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.service.AdopcionService;

@Controller
public class AdopcionControlador {
	
	@Autowired
	private AdopcionService adopcionService;		
	
	@GetMapping("/admin/listaAdopciones")
	public String mostrarAdopciones(Model model) {
		model.addAttribute("adopciones", adopcionService.findAll());
		return "admin/listaAdopciones";
	}
	
	@GetMapping("/cliente/misAdopciones")
	public String mostrarAdopcionCliente(Model model, Cliente cliente) {
		model.addAttribute("adopCliente", adopcionService.findAll());
		return "misAdopciones";
	}

}
