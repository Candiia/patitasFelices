package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
@IdClass(LineaVentaPK.class)
public class LineaVenta {

	@Id @GeneratedValue
	private Long id;
	
	private int cantidad;
	private double subtotal;
	
	@ManyToOne
	private Producto producto;
	 
	@Id
	@ManyToOne
	private Venta venta;
	
	public double getPrecioLineaVenta() {
		return producto.getPrecio() * cantidad;
	}
}
