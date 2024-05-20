package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.LineaVenta;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.Venta;
import com.salesianostriana.dam.proyectofinalprueba.model.exception.ProductoNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinalprueba.repository.VentaRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class ProductoService extends BaseServiceImple<Producto, Long, ProductoRepository>{
	
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private VentaRepository ventaRepository;
	
	public Producto guardar(Categoria categoria, Producto producto) {
		producto.addToCategoria(categoria);
		return productoRepository.save(producto);
	}
	
	public Producto editar(Categoria categoria, Producto producto) {
		producto.removeFromCategoria(producto.getCatProducto());
		producto.addToCategoria(categoria); 
		return productoRepository.save(producto);
		
	}
	
	public void borrar(Long id, Categoria c) {
		buscarProductoPorId(id).removeFromCategoria(c);
		productoRepository.deleteById(id);
	}
	
	public Producto buscarProductoPorId(Long id) throws ProductoNoEncontradoException {
		return productoRepository.findById(id)
				.orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado"));
	}
	
	public int numVentaProducto(Producto producto) {
		return ventaRepository.findNumVentaByProducto(producto);
	}
	
	public List<Producto> buscar(String buscar){
		return repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(buscar, buscar);
	}
	

	public Producto buscarProductoMasVendido() {
		List<Venta> ventas = ventaRepository.findAll();
		        
		Map<Producto, Integer> productoCantidadMap = ventas.stream()
				.flatMap(v -> v.getLineasVentas().stream())
		        .collect(Collectors.groupingBy(LineaVenta::getProducto, Collectors.summingInt(LineaVenta::getCantidad)));

		return productoCantidadMap.entrySet().stream()
		        .max(Comparator.comparingInt(Map.Entry::getValue))
		        .map(Map.Entry::getKey)
				.orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado"));
	}
	
	public List<Producto> findByCategoriaId(Long id){
		return repository.findByCategoriaId(id);
	}
}


