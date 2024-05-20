package com.salesianostriana.dam.proyectofinalprueba.service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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
	        
	    save(adopcion);
	}
	
	public Adopcion buscarAdopcionPorId(Long animalId, Long clienteId){
		AdopcionPK adopcionPk= new AdopcionPK();
		adopcionPk.setClienteId(clienteId);
	    adopcionPk.setAnimalId(animalId);
	    
		return findById(adopcionPk)
				.orElseThrow(() -> new AdopcionNoEncontradoException("Adopción no encontrada"));
	} 
	
	public void borrarAdopcion(Long clienteId, Long animalId) {
	    	
		Adopcion adopcion = buscarAdopcionPorId(animalId, clienteId);
	        
		adopcion.removeFromAnimal(adopcion.getAnimal());
	    adopcion.removeFromCliente(adopcion.getCliente());
	        
	    deleteById(adopcion.getAdopcionPK());
	    
	}
	
	public String buscarMesMasAdopciones() {
		return findAll().stream()
		        .collect(Collectors.groupingBy(
	                      adopcion -> adopcion.getFechaAdopcion().getMonth(),
	                      Collectors.counting()
	              ))
		        .entrySet()
	            .stream()
	            .max(Map.Entry.comparingByValue())
	            .map(m -> m.getKey().getDisplayName(TextStyle.FULL, new Locale("es", "ES")))
	            .orElse("x");
	}            

	

       
	
}
