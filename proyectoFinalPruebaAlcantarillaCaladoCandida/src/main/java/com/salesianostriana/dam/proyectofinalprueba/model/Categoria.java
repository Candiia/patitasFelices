package com.salesianostriana.dam.proyectofinalprueba.model;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Categoria {
	
 	@Id @GeneratedValue
	private Long id;
	 
	private String nombre;
	
	@OneToMany(mappedBy = "catProducto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Producto> listaProducto = new ArrayList<>();
	 
} 
 