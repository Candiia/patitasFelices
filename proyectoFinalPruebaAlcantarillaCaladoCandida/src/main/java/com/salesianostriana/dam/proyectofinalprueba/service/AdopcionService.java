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
	
	public Adopcion buscarAdopcionPorId(AdopcionPK adopcionPK, Long idAnimal , Long idCliente) throws AdopcionNoEncontradoException {
       
		adopcionPK.setClienteId(adopcionPK.getAnimalId());
        adopcionPK.setAnimalId(adopcionPK.getClienteId());
		return adoptarRepository.findById(adopcionPK)
				.orElseThrow(() -> new AdopcionNoEncontradoException("Adopción no encontrada"));
	} 
	
	public void borrarAdopcion(AdopcionPK adopcionPK, Cliente cliente, Animal aniaml) {
	
        buscarAdopcionPorId(adopcionPK, adopcionPK.getAnimalId(), adopcionPK.getClienteId()).removeFromCliente(cliente);
        buscarAdopcionPorId(adopcionPK, adopcionPK.getAnimalId(), adopcionPK.getClienteId()).removeFromAnimal(aniaml);

      
        adoptarRepository.deleteById(adopcionPK);
	}
}
