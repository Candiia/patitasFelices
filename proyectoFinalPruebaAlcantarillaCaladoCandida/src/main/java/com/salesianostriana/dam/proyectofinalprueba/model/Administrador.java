package com.salesianostriana.dam.proyectofinalprueba.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuppressWarnings("serial")
@Entity
@NoArgsConstructor 
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class Administrador extends Usuario{
	
	private String foto;
	private String nombre;
	private String apellido;

	@OneToMany (mappedBy = "admin", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<Venta> listaVenta = new ArrayList<>();
}
