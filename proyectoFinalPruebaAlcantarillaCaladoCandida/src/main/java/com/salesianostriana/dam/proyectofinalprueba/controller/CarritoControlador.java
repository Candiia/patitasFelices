package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.service.CarritoService;
import com.salesianostriana.dam.proyectofinalprueba.service.ProductoService;

@Controller
public class CarritoControlador {
	
	@Autowired
	private CarritoService carritoService;
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/carrito")
	public String showCarrito(@AuthenticationPrincipal Cliente cliente, Model model) {
		if(carritoService.hayCarrito(cliente)) {
			model.addAttribute("productos", carritoService.getproductoEnCarrito(cliente));
			return "carrito";
		}
		
		return"redirect:/admin/mostrarProductos";
	}

	@GetMapping("/productoACarrito/{id}")
	public String agregarProductoCarrito(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal Cliente cliente) {
		Optional<Producto> producto = productoService.findById(id);
		if(producto.isPresent()) {
			carritoService.addProducto(cliente, producto.get(), 1);
			return "redirect/carrito";
		}
		return"redirect:/admin/mostrarProductos";
	}
	
	@GetMapping("/confirmar")
	public String finalizarCompra(@AuthenticationPrincipal Cliente cliente) {
		carritoService.finalizarCompra(cliente);
		return "redirect:/admin/ventasRealizadas";
	}
	
	@GetMapping("/modificar/{id}/cantidad/{cantidad}")
	public String modificar(Cliente cliente, @PathVariable("id") Long id, @PathVariable("cantidad") int cantidad) {
		Optional <Producto> producto = productoService.findById(id);
		if(producto.isPresent()) {
			carritoService.modificar(cliente, producto.get(), cantidad);
		}
		return "redirect:/carrito";
	}

}
