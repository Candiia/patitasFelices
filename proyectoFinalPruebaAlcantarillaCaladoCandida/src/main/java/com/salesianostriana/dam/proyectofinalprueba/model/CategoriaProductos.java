package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class CategoriaProductos {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;

	public CategoriaProductos(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	

}
