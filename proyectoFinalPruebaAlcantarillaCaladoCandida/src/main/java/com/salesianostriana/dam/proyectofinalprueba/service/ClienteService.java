package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.exception.ClienteNoEncontradoException;
import com.salesianostriana.dam.proyectofinalprueba.repository.AdoptarRepository;
import com.salesianostriana.dam.proyectofinalprueba.repository.ClienteRepository;
import com.salesianostriana.dam.proyectofinalprueba.repository.VentaRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;



@Service
public class ClienteService extends BaseServiceImple<Cliente, Long, ClienteRepository>{
	

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private AdoptarRepository adoptarRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Cliente buscarClientePorId(Long id){
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));
	}

	@Override
	public Cliente save(Cliente t) {
		t.setPassword(passwordEncoder.encode(t.getPassword()));
		return super.save(t);
	}

	public int numVentasCliente(Cliente cliente) {
		return ventaRepository.findNumVentasByCliente(cliente);
	}
	
	public int numAdopcionCliente(Cliente cliente) {
		return adoptarRepository.findNumAdopcionByCliente(cliente);
	}
	
	public Cliente buscarClienteConMasAdopciones() {
		return findAll().stream()
                .max(Comparator.comparingInt(cliente -> cliente.getListaAdopcion().size()))
				.orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));
	}

	
	public List<Cliente> buscar(String buscar){
		return repository.findByNombreContainsIgnoreCaseOrUsernameContainsIgnoreCase(buscar, buscar);
	}

	
} 
