package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.exception.ClienteNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.repository.ClienteRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class ClienteService extends BaseServiceImple<Cliente, Long, ClienteRepository>{
	

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Cliente buscarClientePorId(Long id) throws ClienteNoEncontradoException {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));
	}

	public void encriptarContraseya(Cliente cliente) {
		cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));

	}
	

	
} 
