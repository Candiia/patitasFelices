package com.salesianostriana.dam.proyectofinalprueba.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.LineaVenta;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.Venta;

@Service
public class CarritoService {
	
	@Autowired
	private VentaService ventaService;
	
	public void addProducto(Cliente cliente, Producto producto, int cantidad) {
		Venta carrito = getCarrito(cliente);
		
		if(!ventaService.hayProductosEnCarrito(cliente, producto)) {
			carrito.addLineaVenta(
					LineaVenta.builder()
					.producto(producto)
					.cantidad(cantidad)
					.build()
					);	
		}else {
			Optional<LineaVenta> lv = buscarPorProducto(cliente, producto);
			if(lv.isPresent()) {
				modificar(cliente, producto, lv.get().getCantidad()+1);
			}
		}
		
		ventaService.edit(carrito);
	}
	
	
	public void borrar(Cliente cliente, Producto producto){
		Venta carrito = getCarrito(cliente);
		Optional<LineaVenta> eliminar = buscarPorProducto(cliente, producto);
		
		if(eliminar.isPresent()) {
			carrito.removeLineaVenta(eliminar.get());
			ventaService.edit(carrito);
		}	
	}
	
	public Optional<LineaVenta> buscarPorProducto(Cliente cliente,Producto producto){
		Venta carrito = getCarrito(cliente);
		return carrito.getLineasVentas().stream()
				.filter(lv -> lv.getProducto().getId()== producto.getId())
				.findFirst();
	}
	
	
	public void finalizarCompra(Cliente cliente) {
		Venta carrito = getCarrito(cliente);
		
		carrito.setFinalizada(true);
		carrito.setFechaVenta(LocalDate.now());
		carrito.setImporteTotal(getImporte(cliente));
		
		ventaService.edit(carrito);

	}
	
	public void modificar(Cliente cliente,Producto producto, int cantidad ) {
		Venta carrito = getCarrito(cliente);

		if(cantidad <= 0) {
			borrar(cliente, producto);
		}else {
			Optional<LineaVenta> lv = buscarPorProducto(cliente, producto);
			if(lv.isPresent()) {
				LineaVenta a = lv.get();
				a.setCantidad(cantidad);;
				ventaService.edit(carrito);
			}else {
				addProducto(cliente, producto, cantidad);
			}
		}
	}
	
	public boolean hayCarrito(Cliente cliente) {
		return ventaService.existeVentaNoFinaliza(cliente);
	}
	
	public Venta crearCarrito(Cliente cliente) {
		
		Venta carrito = Venta.builder()
				.cliente(cliente)
				.finalizada(false)
				.build();
		
		return carrito;  
	}			
	public Venta getCarrito(Cliente cliente) {
		return ventaService.getVentaNoFinaliza(cliente).orElseGet(() -> crearCarrito(cliente));
	}
	
	public double getImporte(Cliente cliente){
		return getCarrito(cliente).getLineasVentas()
			.stream()
			.mapToDouble(LineaVenta::getPrecioLineaVenta)
			.sum();
	}
	
	public Map<Producto, Integer> getproductoEnCarrito(Cliente cliente){
		return getCarrito(cliente)
				.getLineasVentas()
				.stream()
				.collect(Collectors.toMap(lv -> lv.getProducto(),lv -> lv.getCantidad()));
	}
	
}
