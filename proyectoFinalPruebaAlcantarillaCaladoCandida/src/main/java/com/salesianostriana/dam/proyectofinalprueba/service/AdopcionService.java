package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Adopcion;
import com.salesianostriana.dam.proyectofinalprueba.model.AdopcionPK;
import com.salesianostriana.dam.proyectofinalprueba.repository.AdoptarRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class AdopcionService extends BaseServiceImple<Adopcion, AdopcionPK, AdoptarRepository>{

	@Autowired
	private AdoptarRepository repo;
	
	//crear metodo pasando el cliente y el animal para poder adoptarlo.s
}
