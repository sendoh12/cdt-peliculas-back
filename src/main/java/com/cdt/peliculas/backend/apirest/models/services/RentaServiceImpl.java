package com.cdt.peliculas.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdt.peliculas.backend.apirest.models.dao.IRentaDao;
import com.cdt.peliculas.backend.apirest.models.entity.Renta;

@Service
public class RentaServiceImpl /*implements IRentaService*/{
	
	@Autowired
	private IRentaDao rentaDao;

	@Transactional(readOnly = true)
	public List<Renta> findAll() {
		return rentaDao.findAll();
	}

}
