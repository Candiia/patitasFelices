package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	List<Producto>findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
	@Query("SELECT p FROM Producto p WHERE p.catProducto.id = ?1")
	List<Producto> findByCategoriaId(Long id);
}
