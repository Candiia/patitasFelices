package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.service.AnimalService;
import com.salesianostriana.dam.proyectofinalprueba.service.TipoAnimalService;

@Controller
@RequestMapping("/admin/")
public class AnimalControlador {
	
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
	
	@GetMapping("/detalleAdminAnimal")
	public String detalleAniaml(Model model) {
		model.addAttribute("listaAnimal", animalServ.findAll());
		return "/admin/listaAnimal";
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
		return "redirect:/admin/detalleAdminAnimal";
	}
	
	@GetMapping("/editarAnimal/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
	
		if(animalServ.findById(id).isPresent()) {
			model.addAttribute("animal",  animalServ.findById(id).get());
			model.addAttribute("listaTipos", tipoServ.findAll());
			return  "formAnimal" ; 
		}else {
			return "redirect:/admin/detalleAdminAnimal";
		}
	}
	
	@PostMapping("/editarAnimal/submit")
	public String procesarEditar(@ModelAttribute("animal") Animal animal) {
		animalServ.save(animal);
		return "redirect:/admin/detalleAdminAnimal"; 
	}

	@GetMapping("/eliminarAnimal/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		animalServ.deleteById(id);
		return "redirect:/admin/detalleAdminAnimal";
	}
}
