package com.cdt.peliculas.backend.apirest.models.services;

import java.util.List;

import com.cdt.peliculas.backend.apirest.models.entity.Renta;

public interface IRentaService {
	public List<Renta> findAll();

}
