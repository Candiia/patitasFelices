package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.TipoAnimal;
import com.salesianostriana.dam.proyectofinalprueba.repository.TipoAnimalRepository;

@Service
public class TipoAnimalService {
	
	@Autowired
	private TipoAnimalRepository tipoRepo;
	
	public List<TipoAnimal> findByAll(){
		return tipoRepo.findAll(); 
	}

}
 