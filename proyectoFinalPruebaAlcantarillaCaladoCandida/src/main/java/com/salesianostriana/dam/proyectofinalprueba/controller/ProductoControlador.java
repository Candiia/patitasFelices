package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepository;

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoRepository productoRepositorio;
	
	@GetMapping("/mostrarProductos")
	public String todosProductos(Model model) {
		List<Producto> listaProductos= productoRepositorio.findAll();
		model.addAttribute("listaProductos", listaProductos);
		return "tienda";
	} 
	
	@GetMapping("/detalleProducto")
	public String detalleProducto(@RequestParam Long id, Model model) {
		Producto p = productoRepositorio.findById(id).orElseThrow();
		model.addAttribute("nombre", p.getNombre());
		model.addAttribute("descripcion", p.getDescripcion());
		model.addAttribute("precio", p.getPrecio());
		model.addAttribute("foto", p.getFoto());
		
		return "detalleProducto";
		
		
	}
	
	@GetMapping("/producto")
	public String formularioProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "pantallaAdminProducto";
	}	
	
}
