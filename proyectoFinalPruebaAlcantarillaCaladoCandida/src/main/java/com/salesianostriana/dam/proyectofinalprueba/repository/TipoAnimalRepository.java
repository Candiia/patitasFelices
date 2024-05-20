package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.TipoAnimal;

public interface TipoAnimalRepository extends JpaRepository<TipoAnimal, Long>{

	@Query("SELECT COUNT(a) FROM Animal a WHERE a.tipoAnimal = ?1")
	int findNumTipoByAnimal(TipoAnimal tipo);	
	
	List<TipoAnimal>findByNombreContainsIgnoreCase(String nombre);

} 
