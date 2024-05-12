package com.salesianostriana.dam.proyectofinalprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.salesianostriana.dam.proyectofinalprueba.exception.*;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.repository.ClienteRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class ClienteService extends BaseServiceImple<Cliente, Long, ClienteRepository>{
	
	@Autowired
	private ClienteRepository repository;
	
	
	
	

}
