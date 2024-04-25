/*package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.repository.AnimalRepository;

@Controller
public class AnimalControlador {
	
	@Autowired
	private AnimalRepository animalRepo;

	@GetMapping("/mostrarAnimales")
	public String todosProductos(Model model) {
		List<Animal> listaProductos= animalRepo.findAll();
		model.addAttribute("listaProductos", listaProductos);
		return "adoptar";
	} 
	
	@GetMapping("/detalleAnimal")
	public String detalleAnimal(@RequestParam Long id ,Model model) {
		
		Animal a = animalRepo.findById(id).orElseThrow();
		
		model.addAttribute("apodo", a.getApodo());
		
		return "detalleAnimal";
	}

}*/
