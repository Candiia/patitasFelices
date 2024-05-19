package com.salesianostriana.dam.proyectofinalprueba.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Adopcion;
import com.salesianostriana.dam.proyectofinalprueba.model.AdopcionPK;
import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.exception.AdopcionNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.repository.AdoptarRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

import jakarta.transaction.Transactional;

@Service
public class AdopcionService extends BaseServiceImple<Adopcion, AdopcionPK, AdoptarRepository>{

	@Autowired
	private AdoptarRepository adoptarRepository;
	@Autowired
	private AnimalService  animalService;
	
	@Transactional
	public void adoptarAnimal(Cliente cliente, Long id) {
	
		Animal animal = animalService.buscarAnimalPorId(id);
		
		 	AdopcionPK adopcionPK = new AdopcionPK();
	        adopcionPK.setClienteId(cliente.getId());
	        adopcionPK.setAnimalId(animal.getId());

	        Adopcion adopcion = new Adopcion();
	        adopcion.setFechaAdopcion(LocalDate.now());

	        adopcion.addToCliente(cliente);
	        adopcion.addToAnimal(animal); 
	        
	        adoptarRepository.save(adopcion);
	}
	
	public Adopcion buscarAdopcionPorId(Long animalId, Long clienteId){
		AdopcionPK adopcionPk= new AdopcionPK();
		adopcionPk.setClienteId(clienteId);
	    adopcionPk.setAnimalId(animalId);
	    
		return adoptarRepository.findById(adopcionPk)
				.orElseThrow(() -> new AdopcionNoEncontradoException("Adopción no encontrada"));
	} 
	
	public void borrarAdopcion(Long clienteId, Long animalId) {
	    	
	        Adopcion adopcion = buscarAdopcionPorId(animalId, clienteId);
	        
	        adopcion.removeFromAnimal(adopcion.getAnimal());
	        adopcion.removeFromCliente(adopcion.getCliente());
	        
	        adoptarRepository.deleteById(adopcion.getAdopcionPK());
	    
	}

	
       
	
}
