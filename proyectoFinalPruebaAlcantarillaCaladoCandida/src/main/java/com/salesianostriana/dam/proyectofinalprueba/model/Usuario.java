package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contraseya;
	private String dNI;
	private String email;
	private String telefono;
	private LocalDate fechaNacimiento;
	
}
