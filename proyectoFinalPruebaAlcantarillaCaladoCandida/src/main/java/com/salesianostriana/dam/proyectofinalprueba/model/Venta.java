package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Builder.Default
	private List<LineaVenta> lineasVentas = new ArrayList<>();
	
	
	public void addLineaVenta(LineaVenta lineaVenta) {
		lineaVenta.setVenta(this);
		this.lineasVentas.add(lineaVenta);
	}
	
	public void removeLineaVenta(LineaVenta lineaVenta) {
		lineaVenta.setVenta(null);
		this.getLineasVentas().remove(lineaVenta);
	}

}
