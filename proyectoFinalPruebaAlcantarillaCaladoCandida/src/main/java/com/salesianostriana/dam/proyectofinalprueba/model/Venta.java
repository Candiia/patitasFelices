package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

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
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Venta {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_venta_cliente"))
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_venta_admin"))
	private Administrador admin;
	
	private double importeTotal;
	private LocalDate fechaVenta;
	

}
