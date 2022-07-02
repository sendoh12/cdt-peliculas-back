package com.cdt.peliculas.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdt.peliculas.backend.apirest.models.entity.Renta;


public interface IRentaDao extends JpaRepository<Renta, Long>{

}
