package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Animal {
	@Id @GeneratedValue
	private Long id;
	
	private String apodo;
	private String nombre;
	private String raza;
	private String genero;
	private LocalDate fechaNacimieto;
	private String historia;
	private String aspectosVeterianrios;
	private String foto;
	private boolean adoptado;
}
