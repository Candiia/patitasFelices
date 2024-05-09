package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuppressWarnings("serial")
@Entity
@NoArgsConstructor 
@DiscriminatorValue("C")
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Cliente extends Usuario{

	
}
 