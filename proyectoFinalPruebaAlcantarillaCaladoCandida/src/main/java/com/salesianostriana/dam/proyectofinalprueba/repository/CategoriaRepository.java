package com.salesianostriana.dam.proyectofinalprueba.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query("SELECT COUNT(p) FROM Producto p WHERE p.catProducto = ?1")
	int findNumCategoriaByProducto(Categoria categoria);
	
	List<Categoria>findByNombreContainsIgnoreCase(String nombre);

}
