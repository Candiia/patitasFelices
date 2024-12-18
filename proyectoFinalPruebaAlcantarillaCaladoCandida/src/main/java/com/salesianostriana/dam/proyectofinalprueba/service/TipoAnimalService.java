package com.salesianostriana.dam.proyectofinalprueba.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.TipoAnimal;
import com.salesianostriana.dam.proyectofinalprueba.model.exception.TipoNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.repository.TipoAnimalRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;


@Service
public class TipoAnimalService extends BaseServiceImple<TipoAnimal, Long, TipoAnimalRepository>{
	
	
	@Autowired
	private TipoAnimalRepository tipoAnimalRepository;
	
	public TipoAnimal buscarTipoAnimalPorId(Long id) throws TipoNoEncontradoException {
		return tipoAnimalRepository.findById(id)
				.orElseThrow(() -> new TipoNoEncontradoException("Tipo animal no encontrado"));
	}
	
	public int numAnimal(TipoAnimal tipo) {
		return tipoAnimalRepository.findNumTipoByAnimal(tipo);
	}

	
	public List<TipoAnimal> buscar(String buscar){
		return repository.findByNombreContainsIgnoreCase(buscar);
	}

}
 