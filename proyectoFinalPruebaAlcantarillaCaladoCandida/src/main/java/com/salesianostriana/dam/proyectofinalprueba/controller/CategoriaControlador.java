package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CategoriaControlador {

	@Autowired
	private CategoriaService catService;
	
	@GetMapping("/detalleCategoria")
	public String mostrarCategorias(Model model) {
		model.addAttribute("listaCateg", catService.findAll());
		return "pantallaCategoria";
	}
	
	
	@GetMapping("/agregarCategoria")
	public String agregarCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "redirect:/pantallaCategoria";
	}
	
	@PostMapping("/agregarCategoria/submit")
	public String submit(@ModelAttribute("categoria") Categoria categoria) {
		catService.save(categoria);
		return "redirect:/detalleCategoria";
	}
	
	@GetMapping("/eliminarCategoria/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		catService.deleteById(id); 
		return "redirect:/detalleCategoria";
	}
	
}
