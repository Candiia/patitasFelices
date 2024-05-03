package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.CategoriaProducto;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.service.CategoriaProductoService;
import com.salesianostriana.dam.proyectofinalprueba.service.ProductoService;

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoService productServ;
	
	@Autowired
	private CategoriaProductoService catServ;;
	
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
		return "pantallaAdminProducto";
	} 

	
	@GetMapping("/agregar")
	public String agregarProducto(Model model) {
		model.addAttribute("productoForm", new Producto());
		model.addAttribute("listaCat", catServ.findAll());
		return "formProducto";
	}
	
	@PostMapping("/agregar")
	public String submit(@ModelAttribute("productoForm") Producto producto) {
		productServ.save(producto);
		return "redirect:/detalleAdminProducto";
	}
	
	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
	
		if(productServ.findById(id).isPresent()) {
			model.addAttribute("producto",  productServ.findById(id).get());
			return  "formProducto" ; 
		}else {
			return "redirect:/detalleAdminProducto";
		}
	}
	
	@PostMapping("/editar/submit")
	public String procesarEditar(@ModelAttribute("producto") Producto p) {
		productServ.edit(p);
		return "redirect:/detalleAdminProducto";
	}
	
	
}
