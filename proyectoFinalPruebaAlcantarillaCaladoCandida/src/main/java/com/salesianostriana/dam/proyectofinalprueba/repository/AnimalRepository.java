package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

	@Query("SELECT a FROM Animal a WHERE a.tipoAnimal.id = ?1")
	List<Animal> findByTipoAnimalId(Long id);

}
