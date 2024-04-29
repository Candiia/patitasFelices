package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepo;
	
	public List<Animal> findAll(){
		return animalRepo.findAll();
	}
	
	public Animal findById(Long id) {
		return animalRepo.findById(id).get();
	}

}
