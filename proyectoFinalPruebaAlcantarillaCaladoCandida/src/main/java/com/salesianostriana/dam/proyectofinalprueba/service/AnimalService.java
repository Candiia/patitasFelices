package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.exception.AnimalNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.repository.AdoptarRepository;
import com.salesianostriana.dam.proyectofinalprueba.repository.AnimalRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class AnimalService extends BaseServiceImple<Animal, Long, AnimalRepository> {
	
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private AdoptarRepository adoptarRepository;
	
	public Animal buscarAnimalPorId(Long id) throws AnimalNoEncontradoException {
		return animalRepository.findById(id)
				.orElseThrow(() -> new AnimalNoEncontradoException("Animal no encontrado"));
	}
	
	public int numAdopcion(Animal animal) {
		return adoptarRepository.findNumAdopcionByAnimal(animal);
	}
	
	public List<Animal> findByTipoAnimalId (Long id){
		return animalRepository.findByTipoAnimalId(id);
	}
	
	public List<Animal> buscar(String buscar){
		return repository.findByNombreContainsIgnoreCaseOrApodoContainsIgnoreCase(buscar, buscar);
	}

}


