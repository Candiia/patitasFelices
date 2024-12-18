package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	@Lob
	private Long id;
	
	private String apodo;
	private String nombre;
	private String raza; 
	private String genero;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	@Column(columnDefinition = "TEXT")
	private String historia;
	
	@Column(columnDefinition = "TEXT")
	private String aspectosVeterinarios;
	
	@Column(columnDefinition = "VARCHAR (600)")
	private String foto;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_animal_tipo"))
	private TipoAnimal tipoAnimal;	
	
	@OneToOne (mappedBy = "animal"/*, cascade = {CascadeType.PERSIST, CascadeType.MERGE}*/)
	private Adopcion adopcion;
}
