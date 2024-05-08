package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor 
@DiscriminatorValue("C")
@SuperBuilder
public class Cliente extends Usuario{

	
}
 