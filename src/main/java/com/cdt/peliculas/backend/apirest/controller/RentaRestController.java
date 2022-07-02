package com.cdt.peliculas.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdt.peliculas.backend.apirest.models.entity.Renta;
import com.cdt.peliculas.backend.apirest.models.services.RentaServiceImpl;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class RentaRestController {
	
	@Autowired
	private RentaServiceImpl rentaServiceImpl;
	
	@GetMapping("/rentas")
	public List<Renta> index() {
		return rentaServiceImpl.findAll();
	}

}
