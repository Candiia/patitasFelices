package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.repository.CategoriaProductoRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class CategoriaService extends BaseServiceImple<Categoria, Long, CategoriaProductoRepository>{
	
	@Autowired
	private CategoriaProductoRepository repositorio;
	
	public Categoria borrarCategria(Categoria categoria, Producto producto) {
		producto.removeFromCategoria(categoria);
		return ;
	}

}
