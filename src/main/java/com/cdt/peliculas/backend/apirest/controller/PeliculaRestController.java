package com.cdt.peliculas.backend.apirest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdt.peliculas.backend.apirest.models.entity.Pelicula;
import com.cdt.peliculas.backend.apirest.models.services.PeliculaServiceImpl;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class PeliculaRestController {
	
	@Autowired
	private PeliculaServiceImpl peliculaService;
	
	@GetMapping("/peliculas")
	public List<Pelicula> index() {
		return peliculaService.findAll();
	}
	
	
	@GetMapping("/peliculas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Optional<Pelicula> pelicula = null;
		Map<String, Object> response = new HashMap<>();
		try {
			pelicula = peliculaService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(pelicula == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(pelicula);
	}
	
	@PutMapping("/peliculas/{id}")
	public ResponseEntity<?> update(@RequestBody Pelicula pelicula, @PathVariable Long id) {
		Pelicula peliculaEncontrada = peliculaService.findById(id).get();
		
		Pelicula guardarPeli = null;
		Map<String, Object> response = new HashMap<>();
		guardarPeli = peliculaEncontrada;
		try {
			peliculaEncontrada.setVista_peliculas(pelicula.getVista_peliculas());
			this.peliculaService.save(peliculaEncontrada);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la pelicula");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		response.put("mensaje", "Numero de vistas actualizado");
		response.put("pelicula", guardarPeli);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/peliculas")
	public ResponseEntity<?> showBuscar(@RequestBody Pelicula pelicula) {
		System.out.println(pelicula.getNombre_pelicula());
		List<Pelicula> peli = null;
		Map<String, Object> response = new HashMap<>();
		try {
			peli = peliculaService.findByName(pelicula.getNombre_pelicula());
			System.out.println(peli);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(pelicula == null) {
			response.put("mensaje", "El cliente ID: ".concat(pelicula.getNombre_pelicula().toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return  ResponseEntity.ok(peli);
	}

}
