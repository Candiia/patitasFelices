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

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.service.CategoriaService;


@Controller
@RequestMapping("/admin")
public class CategoriaControlador {

	@Autowired
	private CategoriaService catService;
	
	@GetMapping("/detalleCategoria/")
	public String mostrarCategorias(Model model) {
		model.addAttribute("listaCateg", catService.findAll());
		return "/admin/listaCategoria";
	}
	
	@GetMapping("/detalleCategoria/buscarCateg")
	public String mostrarCategoriasBuscar(Model model, @RequestParam("buscar") String buscar) {
		model.addAttribute("listaCateg", catService.buscar(buscar));
		return "/admin/listaCategoria";
	}
	
	
	@GetMapping("/agregarCategoria")
	public String agregarCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "/admin/formCategoria";
	}
	
	@PostMapping("/agregarCategoria/submit")
	public String submit(@ModelAttribute("categoria") Categoria categoria) {
		catService.save(categoria);
		return "redirect:/admin/detalleCategoria/";
	}
	
	@GetMapping("/eliminarCategoria/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		Categoria categoria = catService.buscarCategoriaPorId(id);
		
		if(categoria != null) {
			if(catService.numCategorias(categoria) == 0) {
				catService.deleteById(id); 
			}else {
				return "redirect:/admin/detalleCategoria/?error=true";
			}
		}
		return "redirect:/admin/detalleCategoria/";
	} 
	
	@GetMapping("/editarCategoria/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
	
		if(catService.findById(id).isPresent()) {
			model.addAttribute("categoria",  catService.buscarCategoriaPorId(id));
			return "/admin/formCategoria"; 
		}else {
			return "redirect:/admin/detalleCategoria/";
		}
	}
	
	@PostMapping("/editarCategoria/submit")
	public String procesarEditar(@ModelAttribute("categoria") Categoria categoria) {
		catService.edit(categoria);
		return "redirect:/admin/detalleCategoria/"; 
	}
	
}
