package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {	
	
	List<Cliente>findByNombreContainsIgnoreCaseOrUsernameContainsIgnoreCase(String nombre, String username);

}
