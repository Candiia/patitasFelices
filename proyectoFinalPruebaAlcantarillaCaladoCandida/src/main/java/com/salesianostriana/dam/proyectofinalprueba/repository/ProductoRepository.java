package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalprueba.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
<<<<<<< HEAD
	//public List<Producto>findByNombreContainsIgnoreCaseOrDescripcionContains(String nombre);
=======
	//List<Producto>findByNombreContainsIgnoreCaseOrDescripcionContains(String nombre);
>>>>>>> 781b0e30705c155c16f77bc5672153fd83535e42

}
