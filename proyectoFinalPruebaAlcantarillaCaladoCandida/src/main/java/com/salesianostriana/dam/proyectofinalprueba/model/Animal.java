/*package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name="fk_animal_tipo"))
	private TipoAnimal tipoAnimal;
	
	public Animal(String apodo, String nombre, String raza, String genero, LocalDate fechaNacimieto, String historia,
			String aspectosVeterianrios, String foto, boolean adoptado, TipoAnimal tipoAnimal) {
		super();
		this.apodo = apodo;
		this.nombre = nombre;
		this.raza = raza;
		this.genero = genero;
		this.fechaNacimieto = fechaNacimieto;
		this.historia = historia;
		this.aspectosVeterianrios = aspectosVeterianrios;
		this.foto = foto;
		this.adoptado = adoptado;
		this.tipoAnimal = tipoAnimal;
	}
	
	
	
}*/
