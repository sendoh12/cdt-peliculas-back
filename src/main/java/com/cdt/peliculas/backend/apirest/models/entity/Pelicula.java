package com.cdt.peliculas.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pelicula;

	@Column(name = "nombre_pelicula")
	private String nombre_pelicula;

	@Column(name = "descripcion_pelicula")
	private String descripcion_pelicula;

	@Column(name = "costo_renta")
	private float costo_renta;

	@Column(name = "vista_peliculas")
	private int vista_peliculas;

	@Column(name = "anio_pelicula")
	private String anio_pelicula;

	@Column(name = "genero_pelicula")
	private String genero_pelicula;

	@Column(name = "imagen_pelicula")
	private String imagen_pelicula;

	@Column(name = "modal_pelicula")
	private String modal_pelicula;

	public Long getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombre_pelicula() {
		return nombre_pelicula;
	}

	public void setNombre_pelicula(String nombre_pelicula) {
		this.nombre_pelicula = nombre_pelicula;
	}

	public String getDescripcion_pelicula() {
		return descripcion_pelicula;
	}

	public void setDescripcion_pelicula(String descripcion_pelicula) {
		this.descripcion_pelicula = descripcion_pelicula;
	}

	public float getCosto_renta() {
		return costo_renta;
	}

	public void setCosto_renta(float costo_renta) {
		this.costo_renta = costo_renta;
	}

	public int getVista_peliculas() {
		return vista_peliculas;
	}

	public void setVista_peliculas(int vista_peliculas) {
		this.vista_peliculas = vista_peliculas;
	}

	public String getAnio_pelicula() {
		return anio_pelicula;
	}

	public void setAnio_pelicula(String anio_pelicula) {
		this.anio_pelicula = anio_pelicula;
	}

	public String getGenero_pelicula() {
		return genero_pelicula;
	}

	public void setGenero_pelicula(String genero_pelicula) {
		this.genero_pelicula = genero_pelicula;
	}

	public String getImagen_pelicula() {
		return imagen_pelicula;
	}

	public void setImagen_pelicula(String imagen_pelicula) {
		this.imagen_pelicula = imagen_pelicula;
	}

	public String getModal_pelicula() {
		return modal_pelicula;
	}

	public void setModal_pelicula(String modal_pelicula) {
		this.modal_pelicula = modal_pelicula;
	}

	private static final long serialVersionUID = 1L;

}
