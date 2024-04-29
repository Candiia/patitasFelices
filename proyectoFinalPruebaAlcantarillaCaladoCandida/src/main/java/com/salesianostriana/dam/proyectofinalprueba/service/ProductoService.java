package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.List;
import java.util.stream.Stream;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired 
	private ProductoRepository produtoRepo;
	
	public List<Producto> findByAll(){
		return produtoRepo.findAll();
	}
	
	public Producto findById(Long id) {
		return produtoRepo.findById(id).get();
	}
	
} 
