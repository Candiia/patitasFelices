package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
public class Animal {
	@Id @GeneratedValue
	private Long id;
	
	private String apodo;
	private String nombre;
	private String raza;
	private String genero;
	
	
	private LocalDate fechaNacimiento;
	
	@Column(columnDefinition = "VARCHAR (550)")
	private String historia;
	
	@Column(columnDefinition = "VARCHAR (550)")
	private String aspectosVeterinarios;
	
	private String foto;
	private boolean adoptado;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_animal_tipo"))
	private TipoAnimal tipoAnimales;	
}
