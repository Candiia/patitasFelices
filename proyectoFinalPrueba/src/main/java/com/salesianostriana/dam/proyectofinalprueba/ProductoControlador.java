package com.salesianostriana.dam.proyectofinalprueba;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	@GetMapping("/mostrarTodos")
	public String todosProductos(Model model) {
		List<Producto> listaProductos= productoRepositorio.findAll();
		model.addAttribute("listaProductos", listaProductos);
		return "tienda";
	} 
	
	@GetMapping("/detalleProducto")
	public String detalleProducto(@RequestParam int id, Model model) {
		Producto p = productoRepositorio.findById(id).orElseThrow();
		model.addAttribute("nombre", p.getNombre());
		model.addAttribute("descripcion", p.getDescripcion());
		model.addAttribute("precio", p.getPrecio());
		model.addAttribute("foto", p.getFoto());
		
		return "detalleProducto";
		
		
	}
	
	
}
