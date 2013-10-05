package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Comunidad;
import com.kenny.app.repository.ComunidadDao;
@Component
public class SimpleComunidadManager implements ComunidadManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ComunidadDao areaProyectoDao;
	@Override
	public List<Comunidad> getComunidadesByDistrito(int distrito_id) {
		// TODO Auto-generated method stub
		return areaProyectoDao.getComunidadListByDistrito(distrito_id);
	}

}
