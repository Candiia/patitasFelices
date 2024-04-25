package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private Long id;
	
	private String apodo;
	private String nombre;
	private String raza;
	private String genero;
	
	
	private LocalDate fechaNacimieto;
	
	@Column(columnDefinition = "VARHCAR 550")
	private String historia;
	
	@Column(columnDefinition = "VARHCAR 550")
	private String aspectosVeterianrios;
	
	private String foto;
	private boolean adoptado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name="fk_animal_tipo"))
	private TipoAnimal tipoAnimal;
	
	public void addTipoAnimal(TipoAnimal tA) {
		this.tipoAnimal = tA;
	}
	
	
}
