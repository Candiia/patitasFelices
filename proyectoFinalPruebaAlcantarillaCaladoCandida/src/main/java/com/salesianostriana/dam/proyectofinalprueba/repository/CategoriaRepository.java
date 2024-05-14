package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	@Query("SELECT c FROM Categoria c WHERE c.nombre = ?1")
	List<Categoria> categoriaFiltro(String nombre);
}
