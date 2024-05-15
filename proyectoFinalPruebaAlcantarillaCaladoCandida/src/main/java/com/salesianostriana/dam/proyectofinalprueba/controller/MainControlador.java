package com.salesianostriana.dam.proyectofinalprueba.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinalprueba.model.Usuario;


@Controller
public class MainControlador {
	
	@GetMapping("/paginaInicial")
	public String paginaInicial(Model model,@AuthenticationPrincipal Usuario usuario) {
		model.addAttribute("isAdmin", usuario.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return "paginaInicial";
	}
	

}
