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

import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.service.CategoriaService;
import com.salesianostriana.dam.proyectofinalprueba.service.ProductoService;

@Controller
@RequestMapping("/admin")
public class ProductoControlador {
	
	@Autowired
	private ProductoService productServ;
	
	@Autowired
	private CategoriaService catServ;;
	
	@GetMapping("/mostrarProductos")
	public String todosProductos(Model model) {
		model.addAttribute("listaProductos", productServ.findAll());
		model.addAttribute("listaCateg", catServ.findAll());
		return "tienda";
	} 
	
	@GetMapping("/detalleProducto")
	public String detalleProducto(@RequestParam Long id, Model model) {
		model.addAttribute("producto", productServ.findById(id).get());
		return "detalleProducto";	
	}
	
	@GetMapping("/detalleAdminProducto")
	public String detalleAdmin(Model model) {
		model.addAttribute("listaProductos", productServ.findAll());
		return "/admin/listaProducto";
	} 

	
	@GetMapping("/agregarProducto")
	public String agregarProducto(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("listaCat", catServ.findAll());
		return "/admin/formProducto";
	}
	
	@PostMapping("/agregarProducto/submit")
	public String submit(@ModelAttribute("producto") Producto producto) {
		productServ.guardar(producto.getCatProducto(), producto);
		return "redirect:/admin/detalleAdminProducto";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
		if(productServ.findById(id).isPresent()) {
			model.addAttribute("producto",  productServ.findById(id).get());
			model.addAttribute("listaCat", catServ.findAll());
			return  "/admin/formProducto" ; 
		}else {
			return "redirect:/admin/detalleAdminProducto";
		}
	}
	
	@PostMapping("/editarProducto/submit")
	public String procesarEditar(@ModelAttribute("producto") Producto producto) {
		productServ.editar(producto.getCatProducto(), producto);
		return "redirect:/admin/detalleAdminProducto"; 
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		productServ.deleteById(id);
		return "redirect:/admin/detalleAdminProducto";
	}

	
	
	
}
