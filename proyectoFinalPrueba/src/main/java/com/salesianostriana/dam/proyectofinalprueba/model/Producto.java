package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
public class Producto {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private double precio;
	private String descripcion;
	private String foto;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_producto_categoria"))
	private CategoriaProductos tipoProducto;
	
	public Producto(String nombre, double precio, String descripcion, String foto, CategoriaProductos tipoProducto) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.foto = foto;
		this.tipoProducto = tipoProducto;
	}

}



