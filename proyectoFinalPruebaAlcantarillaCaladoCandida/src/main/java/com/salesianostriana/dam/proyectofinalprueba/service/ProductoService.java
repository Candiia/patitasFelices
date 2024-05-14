package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.exception.AnimalNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.exception.ProductoNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class ProductoService extends BaseServiceImple<Producto, Long, ProductoRepository>{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
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
	
}


