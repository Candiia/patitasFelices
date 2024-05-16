package com.salesianostriana.dam.proyectofinalprueba.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.exception.AdopcionNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.exception.ProductoNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.model.Adopcion;
import com.salesianostriana.dam.proyectofinalprueba.model.AdopcionPK;
import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
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
	
	public Adopcion buscarAdopcionPorId(AdopcionPK adopcionPK) throws AdopcionNoEncontradoException {
	
		return adoptarRepository.findById(adopcionPK)
				.orElseThrow(() -> new AdopcionNoEncontradoException("Adopción no encontrada"));
	} 
	
	public void borrarAdopcion(Cliente cliente, Animal animal) {
		AdopcionPK adopcion = new AdopcionPK();
		adopcion.getAnimalId();
		adopcion.getClienteId();
        buscarAdopcionPorId(adopcion).removeFromCliente(cliente);
        buscarAdopcionPorId(adopcion).removeFromAnimal(animal);

      
        adoptarRepository.deleteById(adopcion);
	}
}
