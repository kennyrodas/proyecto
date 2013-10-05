package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Distrito;
import com.kenny.app.repository.DistritoDao;
@Component
public class SimpleDistritoManager implements DistritoManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private DistritoDao distritoDao;
	@Override
	public List<Distrito> getDistritosByProvincia(int provincia_id) {
		// TODO Auto-generated method stub
		return this.distritoDao.getDistritoListByProvincia(provincia_id);
	}

}
