package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/")
public class CategoriaControlador {

	@Autowired
	private CategoriaService catService;
	
	@GetMapping("/detalleCategoria")
	public String mostrarCategorias(Model model) {
		model.addAttribute("listaCateg", catService.findAll());
		return "/admin/listaCategoria";
	}
	
	
	@GetMapping("/agregarCategoria")
	public String agregarCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "redirect:/admin/detalleCategoria";
	}
	
	@PostMapping("/agregarCategoria/submit")
	public String submit(@ModelAttribute("categoria") Categoria categoria) {
		catService.save(categoria);
		return "redirect:/admin/detalleCategoria";
	}
	
	@GetMapping("/eliminarCategoria/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		catService.deleteById(id); 
		return "redirect:/admin/detalleCategoria";
	}
	
	@GetMapping("/editarCategoria/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
	
		if(catService.findById(id).isPresent()) {
			model.addAttribute("categoria",  catService.findById(id).get());
			return  "redirect:/admin/detalleCategoria"; 
		}else {
			return "redirect:/admin/detalleCategoria";
		}
	}
	
	@PostMapping("/editarCategoria/submit")
	public String procesarEditar(@ModelAttribute("categoria") Categoria categoria) {
		catService.save(categoria);
		return "redirect:/admin/detalleCategoria"; 
	}
	
}
