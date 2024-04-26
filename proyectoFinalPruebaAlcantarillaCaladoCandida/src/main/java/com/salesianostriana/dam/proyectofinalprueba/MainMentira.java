package com.salesianostriana.dam.proyectofinalprueba;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.model.CategoriaProducto;
import com.salesianostriana.dam.proyectofinalprueba.model.Producto;
import com.salesianostriana.dam.proyectofinalprueba.model.TipoAnimal;
import com.salesianostriana.dam.proyectofinalprueba.repository.AnimalRepository;
import com.salesianostriana.dam.proyectofinalprueba.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinalprueba.repository.TipoAnimalRepository;

import jakarta.annotation.PostConstruct;

@Component
public class MainMentira {
	
	@Autowired
	private ProductoRepository producRepo;
	
	@Autowired
	private TipoAnimalRepository tipoAnimalRepo;
	
	@Autowired
	private AnimalRepository animalRepo;

	@PostConstruct
	public void init() {

		
		Producto p = Producto.builder()
				.nombre("Pipeta")
				.precio( 2.365656)
				.descripcion("Frontline Tri-Act es el antiparasitario para perros de última generación. Producto altamente innovador brinda una nueva protección tota")
				.foto("https://d7rh5s3nxmpy4.cloudfront.net/CMP9365/1/8711231164554.jpg")
				.catProducto(CategoriaProducto.MEDICINA)
				.build();
		
		Producto p1 = Producto.builder()
				.nombre("Collar")
				.precio( 503.2)
				.descripcion("Frontline Tri-Act es el antiparasitario para perros de última generación. Producto altamente innovador brinda una nueva protección tota")
				.foto("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcQcsVqlUtPUqrG6r5MMcl2aCA_mFkP_FRkmaNMpqVJ4Zyfu35npGseenrS2fiUkGh0nqrxRuHY8wqP1TQ4Jv2ZgrrFyLgTevAMYTrNkCn4_Nfyi3vEqCREZ7A")
				.catProducto(CategoriaProducto.ACCESORIO)
				.build();
				
				
		Producto p2 = Producto.builder()
				.nombre("Pienso")
				.precio( 503.2)
				.descripcion("Frontline Tri-Act es el antiparasitario para perros de última generación. Producto altamente innovador brinda una nueva protección tota")
				.foto("https://d7rh5s3nxmpy4.cloudfront.net/CMP9365/1/8711231164554.jpg")
				.catProducto(CategoriaProducto.ALIMENTACION)
				.build();
				
		producRepo.save(p);
		producRepo.save(p1);
		producRepo.save(p2);
		
		TipoAnimal tA1 = TipoAnimal.builder()
				.tipo("Perro")
				.build();
		
		TipoAnimal tA2 = TipoAnimal.builder()
				.tipo("Gato")
				.build();
		
		tipoAnimalRepo.save(tA1);
		tipoAnimalRepo.save(tA2);
		
		
		Animal a1 = Animal.builder()
				.nombre("lucas")
				.raza("chiguagua")
				.adoptado(true)
				.apodo("fgd")
				.aspectosVeterianrios("sadsa")
				.fechaNacimieto(LocalDate.of(2023, 04, 20))
				.genero("macho")
				.foto("https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg")
				.tipoAnimales(tA1)
				.build();
		
		
		Animal a2 = Animal.builder()
				.nombre("lucas")
				.raza("chiguagua")
				.adoptado(true)
				.apodo("fgd")
				.aspectosVeterianrios("asddsa")
				.fechaNacimieto(LocalDate.of(2023, 04, 20))
				.genero("macho")
				.foto("https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg")
				.tipoAnimales(tA1)
				.build();
				
				
		Animal a3 = Animal.builder()
				.nombre("Luna")
				.raza("pinche")
				.adoptado(false)
				.apodo("Lunita")
				.aspectosVeterianrios("djjhasdgashgdasjdga")
				.fechaNacimieto(LocalDate.of(2023, 04, 20))
				.genero("Hembra")
				.foto("https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg")
				.tipoAnimales(tA2)
				.build();
		
		animalRepo.save(a1);
		animalRepo.save(a2);
		animalRepo.save(a3);

	}
	
}
