package com.salesianostriana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalprueba.model.Adopcion;
import com.salesianostriana.dam.proyectofinalprueba.model.AdopcionPK;

public interface AdoptarRepository extends JpaRepository<Adopcion, AdopcionPK>{

}
