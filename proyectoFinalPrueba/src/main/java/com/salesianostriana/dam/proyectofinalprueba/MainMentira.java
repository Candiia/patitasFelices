package com.salesianostriana.dam.proyectofinalprueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinalprueba.model.CategoriaProductos;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.repository.CategoriaProducto;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepositorio;

import jakarta.annotation.PostConstruct;

@Component
public class MainMentira {
	
	@Autowired
	private ProductoRepositorio producRepo;
	
	@Autowired
	private CategoriaProducto cateRepo;
	
	@PostConstruct
	public void init() {
	
		CategoriaProductos c = new CategoriaProductos("medicina");
		CategoriaProductos c2 = new CategoriaProductos("medicina");
		CategoriaProductos c3 = new CategoriaProductos("medicina");
		
		cateRepo.save(c);
		cateRepo.save(c2);
		cateRepo.save(c3);
		
		Producto p = new Producto("Pipeta", 2.365656, " Frontline Tri-Act es el antiparasitario para perros de última generación. Producto altamente innovador,\r\n"
				+ "                        brinda una nueva protección tota", "https://d7rh5s3nxmpy4.cloudfront.net/CMP9365/1/8711231164554.jpg", c);
		Producto p1 = new Producto("Collar", 503.2, "dkjsdhasdhsad", "https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcQcsVqlUtPUqrG6r5MMcl2aCA_mFkP_FRkmaNMpqVJ4Zyfu35npGseenrS2fiUkGh0nqrxRuHY8wqP1TQ4Jv2ZgrrFyLgTevAMYTrNkCn4_Nfyi3vEqCREZ7A",c2);
		Producto p2 = new Producto("Pienso", 503.2, " Frontline Tri-Act es el antiparasita", "https://d7rh5s3nxmpy4.cloudfront.net/CMP9365/1/8711231164554.jpg", c3);

		producRepo.save(p);
		producRepo.save(p1);
		producRepo.save(p2);


	}
	
}
