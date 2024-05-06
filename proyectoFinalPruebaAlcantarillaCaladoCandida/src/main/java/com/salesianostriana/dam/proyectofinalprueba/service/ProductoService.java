package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class ProductoService extends BaseServiceImple<Producto, Long, ProductoRepository>{
	
	@Autowired
	private ProductoRepository repositorio;
	
	public Producto guardar(Categoria categoria, Producto producto) {
		producto.addToCategoria(categoria);
		return repositorio.save(producto);
	}
} 
