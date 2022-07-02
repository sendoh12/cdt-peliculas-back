package com.cdt.peliculas.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdt.peliculas.backend.apirest.models.dao.IPeliculaDao;
import com.cdt.peliculas.backend.apirest.models.entity.Pelicula;


@Service
public class PeliculaServiceImpl /*implements IPeliculaService*/ {
	
	@Autowired
	private IPeliculaDao peliculaDao;

	
	@Transactional(readOnly = true)
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaDao.masRentadas();
		
	}


	public Pelicula save(Pelicula peliculaEncontrada) {
		return peliculaDao.save(peliculaEncontrada);
	}
	
	@Transactional(readOnly = true)
	public Optional<Pelicula> findById(Long id) {
		return peliculaDao.findById(id);
	}

	
	public List<Pelicula> findByName(String nombre) {
		return peliculaDao.findByName(nombre);
	}	

}
