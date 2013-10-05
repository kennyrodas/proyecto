package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Provincia;
import com.kenny.app.repository.ProvinciaDao;
@Component
public class SimpleProvinciaManager implements ProvinciaManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProvinciaDao provinciaDao;
	@Override
	public List<Provincia> getProvinciasByRegion(int region_id) {
		return provinciaDao.getProvinciaListByRegion(region_id);
	}

}
