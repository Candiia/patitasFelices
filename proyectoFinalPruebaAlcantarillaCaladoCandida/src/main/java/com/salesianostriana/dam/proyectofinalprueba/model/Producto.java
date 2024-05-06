package com.salesianostriana.dam.proyectofinalprueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity 
@Builder
public class Producto {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	@Column(columnDefinition = "VARCHAR (550)")
	private double precio;
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	private String foto;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_producto_categoria"))
	private Categoria catProducto;
	
	public void addToCategoria(Categoria categoria) {
		this.catProducto = categoria; 
		categoria.getListaProducto().add(this);
	}
	
	public void removeFromCategoria(Categoria categoria) {
		this.catProducto = null;
		categoria.getListaProducto().remove(this);
	}
	


}



