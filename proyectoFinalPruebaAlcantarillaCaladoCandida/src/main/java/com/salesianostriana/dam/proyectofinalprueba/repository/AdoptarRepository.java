package com.salesianostriana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Adopcion;
import com.salesianostriana.dam.proyectofinalprueba.model.AdopcionPK;
import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;

public interface AdoptarRepository extends JpaRepository<Adopcion, AdopcionPK>{
	
	@Query("SELECT COUNT(a) FROM Adopcion a WHERE a.cliente = ?1")
	int findNumAdopcionByCliente(Cliente cliente);

	
	@Query("SELECT COUNT (a) FROM Adopcion a WHERE a.animal = ?1")
	int findNumAdopcionByAnimal(Animal animal);
	
	

}
