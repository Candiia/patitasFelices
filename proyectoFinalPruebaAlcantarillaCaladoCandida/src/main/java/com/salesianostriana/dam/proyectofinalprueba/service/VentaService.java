package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Administrador;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.Venta;
import com.salesianostriana.dam.proyectofinalprueba.repository.VentaRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

@Service
public class VentaService  extends BaseServiceImple<Venta, Long, VentaRepository>{

	public boolean existeVentaNoFinaliza(Administrador admin) {
		return this.repository.existVentaNoFinalizada(admin);  
	}
	
	public Optional<Venta> getVentaNoFinaliza(Administrador admin) {
		return this.repository.findByFinalizadaAndAdministrador(admin); 
	}

	public boolean hayProductosEnCarrito(Administrador admin, Producto producto) {
		return this.repository.hayProductoEnCarrito(admin, producto);
	}

}
