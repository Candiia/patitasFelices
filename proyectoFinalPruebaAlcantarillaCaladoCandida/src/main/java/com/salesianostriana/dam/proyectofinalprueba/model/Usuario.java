package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	
}
