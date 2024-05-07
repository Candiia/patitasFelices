package com.salesianostriana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.service.AnimalService;

public interface AnimalRepository extends JpaRepository<Animal, Long>{


}
