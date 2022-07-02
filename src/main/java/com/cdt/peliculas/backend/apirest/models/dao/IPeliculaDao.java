package com.cdt.peliculas.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdt.peliculas.backend.apirest.models.entity.Pelicula;

public interface IPeliculaDao extends JpaRepository<Pelicula, Long>{
	@Query(value ="select * from peliculas p where UPPER(p.nombre_pelicula) like %:nombre%", nativeQuery = true)//busqueda por un solo campo
	public List<Pelicula> findByName(@Param(value = "nombre") String nombre);
	
	@Query(value ="select * from peliculas p where p.vista_peliculas >= 10", nativeQuery = true)
	public List<Pelicula> masRentadas();
	
}
