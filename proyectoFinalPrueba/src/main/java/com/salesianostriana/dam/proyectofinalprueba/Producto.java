package com.salesianostriana.dam.proyectofinalprueba;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
public class Producto {
	
	@Id
	private int id;
	
	private String nombre;
	private double precio;
	private String descripcion;
	private String foto;
	private TipoProducto tipoProducto;

}
