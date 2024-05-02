package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		List<Producto> listaProductos= productServ.findAll();
		List<CategoriaProducto> listaCat = catServ.findAll();
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("listaCateg", listaCat);
		return "tienda";
	} 
	
	@GetMapping("/detalleProducto")
	public String detalleProducto(@RequestParam Long id, Model model) {
		Producto producto = productServ.findById(id).get();
		model.addAttribute("producto", producto);
		return "detalleProducto";
		
		
	}
	
	@GetMapping("/detalleAdminProducto")
	public String detalleAdmin(Model model) {
		List<Producto> listaProducto= productServ.findAll();
		model.addAttribute("listaProductos", listaProducto);
		return "pantallaAdminProducto";
	} 

	
	@GetMapping("/addProducto")
	public String formProducto(Model model) {
		Producto producto = new Producto();
		List<CategoriaProducto> listaCat =  catServ.findAll();
		model.addAttribute("productoForm", producto);
		model.addAttribute("listaCat", listaCat); 
		return "formProducto";
	}
	
	@PostMapping("/addProducto")
	public String submit(@ModelAttribute("productoForm") Producto producto) {
		productServ.save(producto);
		return "redirect:/detalleAdminProducto";
	}
}
