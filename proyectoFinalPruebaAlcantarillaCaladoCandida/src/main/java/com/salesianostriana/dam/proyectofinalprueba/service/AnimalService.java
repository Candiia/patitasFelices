package com.salesianostriana.dam.proyectofinalprueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalprueba.model.Animal;
import com.salesianostriana.dam.proyectofinalprueba.repository.AnimalRepository;
import com.salesianostriana.dam.proyectofinalprueba.service.base.BaseServiceImple;

import jakarta.transaction.Transactional;

@Service
public class AnimalService extends BaseServiceImple<Animal, Long, AnimalRepository> {
	
	
}


