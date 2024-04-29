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
import com.salesianostriana.dam.proyectofinalprueba.service.ProductoService;

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoService productServ;
	
	@GetMapping("/mostrarProductos")
	public String todosProductos(Model model) {
		List<Producto> listaProductos= productServ.findByAll();
		model.addAttribute("listaProductos", listaProductos);
		return "tienda";
	} 
	
	@GetMapping("/detalleProducto")
	public String detalleProducto(@RequestParam Long id, Model model) {
		Producto p = productServ.findById(id);
		model.addAttribute("nombre", p.getNombre());
		model.addAttribute("descripcion", p.getDescripcion());
		model.addAttribute("precio", p.getPrecio());
		model.addAttribute("foto", p.getFoto());
		
		return "detalleProducto";
		
		
	}
}
