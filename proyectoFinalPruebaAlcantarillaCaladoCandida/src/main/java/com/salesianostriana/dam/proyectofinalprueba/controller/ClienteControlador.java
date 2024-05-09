package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.service.AnimalService;
import com.salesianostriana.dam.proyectofinalprueba.service.TipoAnimalService;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {
	
	@Autowired
	private AnimalService animalServ;
	
	@Autowired 
	private TipoAnimalService tipoServ;
	
	@GetMapping("/mostrarAnimales")
	public String listaAnimalAdopcion(Model model) {
		model.addAttribute("listaAnimales", animalServ.findAll());
		model.addAttribute("listaTipos", tipoServ.findAll());
		return "adoptar";
	} 
	
	@GetMapping("/detalleAnimal")
	public String detalleAnimal(@RequestParam Long id,  Model model) {
		model.addAttribute("animal",  animalServ.findById(id).get());
		return "detalleAnimal";
	}
	
	
}
