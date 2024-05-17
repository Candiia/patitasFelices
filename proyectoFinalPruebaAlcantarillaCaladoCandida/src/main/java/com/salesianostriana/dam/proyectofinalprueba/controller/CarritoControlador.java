package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalprueba.model.Administrador;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.service.CarritoService;
import com.salesianostriana.dam.proyectofinalprueba.service.ProductoService;

@Controller
@RequestMapping("/admin")
public class CarritoControlador {
	
	@Autowired
	private CarritoService carritoService;
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/carrito")
	public String showCarrito(@AuthenticationPrincipal Administrador admin, Model model) {
		if(carritoService.hayCarrito(admin)) {
			model.addAttribute("productos", carritoService.getProductoEnCarrito(admin));
			return "/carrito";
		}
		
		return"/carrito";
	}

	@GetMapping("/productoACarrito/{id}")
	public String agregarProductoCarrito(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal Administrador admin) {
		Optional<Producto> producto = productoService.findById(id);
		if(producto.isPresent()) {
			carritoService.addProducto(producto.get(), 1, admin);
			return "redirect:/admin/carrito";
		}
		return"redirect:/admin/mostrarProductos";
	}
	
	@GetMapping("/confirmar")
	public String finalizarCompra(@AuthenticationPrincipal Administrador admin, Cliente cliente) {
		carritoService.finalizarCompra(admin, cliente);
		return "redirect:/admin/ventasRealizadas";
	}
	
	@GetMapping("/modificar/{id}/cantidad/{cantidad}")
	public String modificar(@AuthenticationPrincipal Administrador admin, @PathVariable("id") Long id, @PathVariable("cantidad") int cantidad) {
		Optional <Producto> producto = productoService.findById(id);
		if(producto.isPresent()) {
			carritoService.modificar(producto.get(), cantidad, admin);
		}
		return "redirect:/admin/carrito";
	}
	
	
	@GetMapping("/carrito/eliminar/{id}")  
	public String eliminarProducto(Administrador admin, @PathVariable("id") Long id) {
        Optional <Producto> producto = productoService.findById(id);
        if(producto.isPresent()) {
           carritoService.borrarProducto(producto.get(), admin);
           return "redirect:/admin/carrito";
        }
        return "redirect:/admin/carrito";
    }

}
