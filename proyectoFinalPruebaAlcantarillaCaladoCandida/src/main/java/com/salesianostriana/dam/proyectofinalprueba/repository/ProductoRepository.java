package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalprueba.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	//List<Producto>findByNombreContainsIgnoreCaseOrDescripcionContains(String nombre);

}
