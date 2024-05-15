package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.exception.CategoriaNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.repository.CategoriaRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class CategoriaService extends BaseServiceImple<Categoria, Long, CategoriaRepository>{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarCategoriaPorId(Long id) throws CategoriaNoEncontradoException {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new CategoriaNoEncontradoException("Categoría no encontrado"));
	}

	public int numCategorias(Categoria categoria) {
		return categoriaRepository.findNumCategoriaByProducto(categoria);
	}
}
