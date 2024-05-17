package com.salesianostriana.dam.proyectofinalprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

	@Query("SELECT COUNT(v) FROM Venta v WHERE v.cliente = ?1")
	int findNumVentasByCliente(Cliente cliente);

	@Query("SELECT COUNT(v) FROM Venta v LEFT JOIN v.lineasVentas lv WHERE lv.producto = ?1")
	int findNumVentaByProducto(Producto producto);
	
	
}

