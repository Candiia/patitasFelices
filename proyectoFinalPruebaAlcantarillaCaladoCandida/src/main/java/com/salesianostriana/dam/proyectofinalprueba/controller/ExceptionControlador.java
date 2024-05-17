package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.salesianostriana.dam.proyectofinalprueba.model.exception.ProductoNoEncontradoException;

@ControllerAdvice
public class ExceptionControlador {
	
	@ExceptionHandler(ProductoNoEncontradoException.class)
	public ModelAndView handleProductoNoEncontradoException(ProductoNoEncontradoException exP) {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("a", exP.getMessage()); //nombre que le demos
		modelView.setViewName("/s");
		return modelView;
	}
	

}
