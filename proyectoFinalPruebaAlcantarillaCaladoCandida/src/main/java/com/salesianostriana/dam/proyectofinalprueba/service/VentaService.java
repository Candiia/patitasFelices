package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.Venta;
import com.salesianostriana.dam.proyectofinalprueba.repository.VentaRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class VentaService  extends BaseServiceImple<Venta, Long, VentaRepository>{

	public boolean existeVentaNoFinaliza(Cliente cliente) {
		return this.repository.findByFinalizadaAndCliente(false, cliente);  
	}
	
	public Optional<Venta> getVentaNoFinaliza(Cliente cliente) {
		return this.getVentaNoFinaliza(cliente); 
	}

	public boolean hayProductosEnCarrito(Cliente cliente, Producto producto) {
		return false;
	}

}
