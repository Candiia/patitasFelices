package com.salesianostriana.dam.proyectofinalprueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MainMentira {
	
	@Autowired
	private ProductoRepositorio producRepo;
	
	@PostConstruct
	public void init() {
		Producto p = new Producto(1, "pan", 2.3, " Frontline Tri-Act es el antiparasitario para perros de última generación. Producto altamente innovador,\r\n"
				+ "                        brinda una nueva protección tota", "https://d7rh5s3nxmpy4.cloudfront.net/CMP9365/1/8711231164554.jpg", TipoProducto.MEDICINA);
		Producto p1 = new Producto(2, "lechuga", 503.2, "dkjsdhasdhsad", "https://d7rh5s3nxmpy4.cloudfront.net/CMP9365/1/8711231164554.jpg", TipoProducto.ACCESORIOS);
		Producto p2 = new Producto(3, "harina", 503.2, " Frontline Tri-Act es el antiparasita", "https://d7rh5s3nxmpy4.cloudfront.net/CMP9365/1/8711231164554.jpg", TipoProducto.ALIMENTACION);

		producRepo.save(p);
		producRepo.save(p1);
		producRepo.save(p2);
	}
	
}
