package com.salesianostriana.dam.proyectofinalprueba.security;

import java.util.List;

import org.hibernate.metamodel.mapping.DiscriminatorValueDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinalprueba.model.Usuario;
import com.salesianostriana.dam.proyectofinalprueba.repository.UsuarioRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.DiscriminatorValue;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final UsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
	
		Usuario admin = Usuario.builder().nombreUsuario("admin")
				.contraseya(passwordEncoder.encode("admin"))
				.getClass().getAnnotation(DiscriminatorValue
				.build();	
		repo.saveAll(List.of( admin));
		
	}

}
