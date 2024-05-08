package com.salesianostriana.dam.proyectofinalprueba.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServicesImpl implements UserDetailsService{

	private final UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repo.findFirstByNombreUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
	}

}
