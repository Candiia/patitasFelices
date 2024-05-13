package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class Cliente extends Usuario{
	
	private String nombre;
	private String apellido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private String dni;
	private String email;
	private String telefono;
	@Column(columnDefinition = "VARCHAR (600)")
	private String foto;
	
	
	@OneToMany (mappedBy = "cliente", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Adopcion> adopcion = new ArrayList<>();

	@OneToMany (mappedBy = "cliente", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<Venta> listaVenta = new ArrayList<>();
	
	
	

}
 