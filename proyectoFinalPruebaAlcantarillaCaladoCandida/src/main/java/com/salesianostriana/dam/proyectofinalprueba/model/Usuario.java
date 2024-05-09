package com.salesianostriana.dam.proyectofinalprueba.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")

public class Usuario implements UserDetails {

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contraseya;
	private String dNI;
	private String email;
	private String telefono;
	private LocalDate fechaNacimiento;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		
		if ("A".equals(this.getClass().getAnnotation(DiscriminatorValue.class).value())) {
	        role += "ADMIN";
	    } else {
	        role += "USER";
	    }
	    return List.of(new SimpleGrantedAuthority(role));
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String getPassword() {
		return null;
	}
	
	@Override
	public String getUsername() {
		
		return null;
	}
	
}
