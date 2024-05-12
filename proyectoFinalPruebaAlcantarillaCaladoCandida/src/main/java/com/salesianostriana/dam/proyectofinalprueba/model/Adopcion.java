package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Adopcion {
	
	@EmbeddedId
	@Builder.Default
	private AdopcionPK adopcionPK = new AdopcionPK();
	
	@OneToOne
	@MapsId("animal_id")
	@JoinColumn(name = "animal_id")
	private Animal animal;
	
	@ManyToOne
	@MapsId("cliente_id")
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaAdopcion;

	public void addToCliente(Cliente c) {
		c.getAdopcion().add(this);
		this.cliente=c;
	}
	
	public void removeFromCliente(Cliente c) {
		c.getAdopcion().remove(this);
		this.cliente = null;
	}
}
