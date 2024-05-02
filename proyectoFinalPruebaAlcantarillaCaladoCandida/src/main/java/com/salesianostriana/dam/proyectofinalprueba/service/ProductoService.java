package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class ProductoService extends BaseServiceImple<Producto, Long, ProductoRepository>{
	
	public List<Producto> ProductoMasVendidos(){
		
	}
	
} 
