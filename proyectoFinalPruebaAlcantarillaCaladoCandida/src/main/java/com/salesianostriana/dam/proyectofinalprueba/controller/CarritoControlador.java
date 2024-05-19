package com.salesianostriana.dam.proyectofinalprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalprueba.model.Administrador;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.service.CarritoService;
import com.salesianostriana.dam.proyectofinalprueba.service.ClienteService;
import com.salesianostriana.dam.proyectofinalprueba.service.ProductoService;

@Controller
@RequestMapping("/admin")
public class CarritoControlador {
	
	@Autowired
	private CarritoService carritoService;
	@Autowired
	private ProductoService productoService;
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/carrito")
	public String showCarrito(@AuthenticationPrincipal Administrador admin, Model model) {
		if(carritoService.hayCarrito(admin)) {
			model.addAttribute("lineaVenta", carritoService.getProductoEnCarrito(admin));
			model.addAttribute("importeTotal", carritoService.getImporte(admin));
			model.addAttribute("clientes", clienteService.findAll());
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
	
	@PostMapping("/confirmar")
	public String finalizarCompra(@AuthenticationPrincipal Administrador admin, @RequestParam Long idCliente) {
		carritoService.finalizarCompra(admin, idCliente);
		return "redirect:/admin/mostrarProductos";
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
	public String eliminarProducto(@PathVariable("id") Long id, @AuthenticationPrincipal Administrador admin) {
        Optional <Producto> producto = productoService.findById(id);
        if(producto.isPresent()) {
           carritoService.borrarProducto(producto.get(), admin);
           return "redirect:/admin/carrito";
        }
        return "redirect:/admin/carrito";
    }

}
