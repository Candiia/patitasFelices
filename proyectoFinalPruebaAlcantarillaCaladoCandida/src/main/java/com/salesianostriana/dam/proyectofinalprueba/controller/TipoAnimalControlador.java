package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.TipoAnimal;
import com.salesianostriana.dam.proyectofinalprueba.service.TipoAnimalService;

@Controller
@RequestMapping("/admin")
public class TipoAnimalControlador {
	
	@Autowired
	private TipoAnimalService tipoService;
	
	@GetMapping("/listadoTipoAnimal")
	public String mostrarTiposAnimales(Model model) {
		model.addAttribute("listaTipo", tipoService.findAll());
		return "/admin/listaTipoAnimal";
	}
	
	@GetMapping("/agregarTipoAnimal")
	public String agregarTipoAnimal(Model model) {
		model.addAttribute("tipo", new TipoAnimal());
		return "/admin/formTipoAnimal";
	}
	
	@PostMapping("/agregarTipoAnimal/submit")
	public String submit(@ModelAttribute("tipo") TipoAnimal tipo) {
		tipoService.save(tipo);
		return "redirect:/admin/listadoTipoAnimal";
	}

	@GetMapping("/editarTipo/{id}")
	public String editarTipo(@PathVariable("id") Long id, Model model) {
	
		if(tipoService.findById(id).isPresent()) {
			model.addAttribute("tipo",  tipoService.findById(id).get());
			return "/admin/formTipoAnimal"; 
		}else {
			return "redirect:/admin/listadoTipoAnimal";
		}
	}
	
	@PostMapping("/editarTipo/submit")
	public String procesarEditar(@ModelAttribute("tipo") TipoAnimal tipo) {
		tipoService.save(tipo);
		return "redirect:/admin/listadoTipoAnimal"; 
	}
}
