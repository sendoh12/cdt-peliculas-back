package com.cdt.peliculas.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "renta")
public class Renta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_renta;

	@Column(name = "dias_renta")
	private int dias_renta;

	@Column(name = "descripcion_renta")
	private String descripcion_renta;

	public Long getId_renta() {
		return id_renta;
	}

	public void setId_renta(Long id_renta) {
		this.id_renta = id_renta;
	}

	public int getDias_renta() {
		return dias_renta;
	}

	public void setDias_renta(int dias_renta) {
		this.dias_renta = dias_renta;
	}

	public String getDescripcion_renta() {
		return descripcion_renta;
	}

	public void setDescripcion_renta(String descripcion_renta) {
		this.descripcion_renta = descripcion_renta;
	}

	private static final long serialVersionUID = 1L;

}
