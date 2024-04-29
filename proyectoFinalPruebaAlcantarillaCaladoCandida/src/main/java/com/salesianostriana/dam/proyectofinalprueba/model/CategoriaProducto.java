package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class CategoriaProducto {
	
	@Id @GeneratedValue
	private Long id;
	 
	private String categoria;

}
