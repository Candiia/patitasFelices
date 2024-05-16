package com.salesianostriana.dam.proyectofinalprueba.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class AdopcionPK implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long clienteId;
	
	private Long animalId;

}
