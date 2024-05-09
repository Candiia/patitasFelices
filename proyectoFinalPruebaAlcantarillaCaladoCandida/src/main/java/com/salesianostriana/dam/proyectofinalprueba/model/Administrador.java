package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuppressWarnings("serial")
@Entity
@NoArgsConstructor 
@DiscriminatorValue("A")
@SuperBuilder 
@Data
@EqualsAndHashCode (callSuper = false)
public class Administrador extends Usuario{

}
