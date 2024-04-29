package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.TipoAnimal;
import com.salesianostriana.dam.proyectofinalprueba.repository.AnimalRepository;
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
		List<Animal> listaAnimales= animalServ.findAll();
		List<TipoAnimal> listaTipos = tipoServ.findAll();
		model.addAttribute("listaAnimales", listaAnimales);
		model.addAttribute("listaTipos", listaTipos);
		return "adoptar";
	} 
	
	@GetMapping("/detalleAnimal")
	public String detalleAnimal(@RequestParam Long id,  Model model) {
		
		Animal animal = animalServ.findById(id).get();
		model.addAttribute("animal", animal);
		return "detalleAnimal";
	}
	

	
	@GetMapping("/detalleAdminAnimal")
	public String detalleAdmin(Model model) {
		List<Animal> listaAnimales= animalServ.findAll();
		model.addAttribute("listaAnimal", listaAnimales);
		return "pantallaAdminAnimal";
	} 
	

}
