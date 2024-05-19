package com.salesianostriana.dam.proyectofinalprueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalprueba.model.Administrador;
import com.salesianostriana.dam.proyectofinalprueba.model.Cliente;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

	@Query("SELECT COUNT(v) FROM Venta v WHERE v.cliente = ?1")
	int findNumVentasByCliente(Cliente cliente);

	@Query("SELECT COUNT(v) FROM Venta v LEFT JOIN v.lineasVentas lv WHERE lv.producto = ?1")
	int findNumVentaByProducto(Producto producto);
	

	@Query("""
			SELECT v
			FROM Venta v 
			WHERE v.finalizada = false
			AND v.admin = ?1
			""")
	Optional<Venta> findByFinalizadaAndAdministrador(Administrador admin);

	@Query("""
			SELECT COUNT(v) > 0
			FROM Venta v 
			WHERE v.finalizada = false
			AND v.admin = ?1
			""")
	boolean existVentaNoFinalizada(Administrador admin);
	
	@Query("""
			SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END 
			FROM Venta v left JOIN v.lineasVentas lv WHERE v.admin
			= ?1 and lv.producto = ?2 AND finalizada = false
			""")
	boolean hayProductoEnCarrito(Administrador admin, Producto producto);
	
	List<Venta> findByFinalizadaTrue();
}

