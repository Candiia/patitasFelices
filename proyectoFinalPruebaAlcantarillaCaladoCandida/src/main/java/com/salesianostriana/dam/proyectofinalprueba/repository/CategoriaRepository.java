package com.salesianostriana.dam.proyectofinalprueba.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query("SELECT COUNT(p) FROM Producto p WHERE p.catProducto = ?1")
	int findNumCategoriaByProducto(Categoria categoria);
}
