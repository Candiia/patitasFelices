package com.salesianostriana.dam.proyectofinalprueba.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Administrador;
import com.salesianostriana.dam.proyectofinalprueba.model.LineaVenta;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.Venta;

@Service
public class CarritoService {
	
	@Autowired
	private VentaService ventaService;
	@Autowired
	private ClienteService clienteService;
	
	public void addProducto(Producto producto, int cantidad, Administrador admin) {
		Venta carrito = getCarrito(admin);
		
		if(!ventaService.hayProductosEnCarrito(admin, producto)) {
			carrito.addLineaVenta(
					LineaVenta.builder()
					.producto(producto)
					.cantidad(cantidad)
					.subtotal(cantidad * producto.getPrecio())
					.build()
					);	
		}else {
			Optional<LineaVenta> lv = buscarPorProducto(producto, admin);
			if(lv.isPresent()) {
				modificar(producto, lv.get().getCantidad()+1, admin);
			}
		}
		
		ventaService.edit(carrito);
	}
	
	
	public void borrarProducto(Producto producto, Administrador admin){
		Venta carrito = getCarrito(admin);
		Optional<LineaVenta> eliminar = buscarPorProducto(producto, admin);
		
		if(eliminar.isPresent()) {
			carrito.removeLineaVenta(eliminar.get());
			ventaService.edit(carrito);
		}	
	}
	
	public Optional<LineaVenta> buscarPorProducto(Producto producto, Administrador admin){
		Venta carrito = getCarrito(admin);
		return carrito.getLineasVentas().stream()
				.filter(lv -> lv.getProducto().getId()== producto.getId())
				.findFirst();
	}
	
	
	public void finalizarCompra(Administrador admin, Long idCliente) {
		Venta carrito = getCarrito(admin);
		
		carrito.setFinalizada(true);
		carrito.setFechaVenta(LocalDate.now());
		carrito.setImporteTotal(getImporte(admin));
		carrito.setCliente(clienteService.buscarClientePorId(idCliente));
		ventaService.edit(carrito);

	}
	
	public void modificar(Producto producto, int cantidad, Administrador admin) {
		Venta carrito = getCarrito(admin);

		if(cantidad <= 0) {
			borrarProducto(producto, admin);
		}else {
			Optional<LineaVenta> lv = buscarPorProducto(producto, admin);
			if(lv.isPresent()) {
				LineaVenta a = lv.get();
				a.setCantidad(cantidad);
				a.setSubtotal(a.getPrecioLineaVenta());
				ventaService.edit(carrito);
			}else {
				addProducto(producto, cantidad, admin);
			}
		}
	}
	
	public boolean hayCarrito(Administrador admin) {
		return ventaService.existeVentaNoFinaliza(admin);
	}
	
	public Venta crearCarrito(Administrador admin) {
		
		Venta carrito = Venta.builder()
				.admin(admin)
				.finalizada(false)
				.build();
		ventaService.save(carrito);
		return carrito;  
	}			
	public Venta getCarrito(Administrador admin) {
		return ventaService.getVentaNoFinaliza(admin).orElseGet(() -> crearCarrito(admin));
	}
	
	public double getImporte(Administrador admin){
		return getCarrito(admin).getLineasVentas()
			.stream()
			.mapToDouble(lv -> lv.getSubtotal())
			.sum();
	}
	
	public List<LineaVenta> getProductoEnCarrito(Administrador admin){
		return getCarrito(admin).getLineasVentas();
	}
	
}
