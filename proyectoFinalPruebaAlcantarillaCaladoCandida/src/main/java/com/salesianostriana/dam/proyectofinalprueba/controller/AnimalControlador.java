package com.salesianostriana.dam.proyectofinalprueba.controller;

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
		List<Animal> listaAnimales= animalRepo.findAll();
		model.addAttribute("listaAnimales", listaAnimales);
		return "adoptar";
	} 
	
	@GetMapping("/detalleAnimal")
	public String detalleAnimal(@RequestParam Long id ,Model model) {
		
		Animal a = animalRepo.findById(id).orElseThrow();
		
		model.addAttribute("apodo", a.getApodo());
		model.addAttribute("nombre", a.getNombre());
		model.addAttribute("raza", a.getRaza());
		model.addAttribute("genero", a.getGenero());
		model.addAttribute("aspVeterianarios", a.getAspectosVeterianrios());
		model.addAttribute("foto", a.getFoto());
		model.addAttribute("historia", a.getHistoria());
		model.addAttribute("tipoAnimal", a.getTipoAnimales());
		model.addAttribute("fechaNacimiento", a.getFechaNacimieto());
		
		return "detalleAnimal";
	}

}
