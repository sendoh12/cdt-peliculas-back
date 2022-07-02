package com.cdt.peliculas.backend.apirest.models.services;

import java.util.List;

import com.cdt.peliculas.backend.apirest.models.entity.Pelicula;

public interface IPeliculaService  {
	public List<Pelicula> findAll();
	public Pelicula save(Pelicula pelicula);
	public Pelicula findById(Long id);
	public List<Pelicula> findByName(String nombre);
}
