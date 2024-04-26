package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity 
@Builder
public class Producto {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private double precio;
	private String descripcion;
	private String foto;
	
	@Enumerated
	private CategoriaProducto catProducto;
	


}



