package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.service.AnimalService;
import com.salesianostriana.dam.proyectofinalprueba.service.TipoAnimalService;

@Controller
public class AnimalControlador {
	
	@Autowired
	private AnimalService animalServ;
	
	@Autowired 
	private TipoAnimalService tipoServ;

	@GetMapping("/mostrarAnimales")
	public String todosProductos(Model model) {
		
		model.addAttribute("listaAnimales", animalServ.findAll());
		model.addAttribute("listaTipos", tipoServ.findAll());
		return "adoptar";
	} 
	
	@GetMapping("/detalleAnimal")
	public String detalleAnimal(@RequestParam Long id,  Model model) {
		model.addAttribute("animal",  animalServ.findById(id).get());
		return "detalleAnimal";
	}
	
	@GetMapping("/detalleAdminAnimal")
	public String detalleAdmin(Model model) {
		model.addAttribute("listaAnimal", animalServ.findAll());
		return "pantallaAdminAnimal";
	} 
	
	
	@GetMapping("/agregarAnimal")
	public String agregarAnimal(Model model) {
		model.addAttribute("animal", new Animal());
		model.addAttribute("listaTipos", tipoServ.findAll());
		return "formAnimal";
	}
	
	@PostMapping("/agregarAnimal/submit")
	public String submit(@ModelAttribute("animal") Animal animal) {
		animalServ.save(animal);
		return "redirect:/detalleAdminAnimal";
	}
	

}
