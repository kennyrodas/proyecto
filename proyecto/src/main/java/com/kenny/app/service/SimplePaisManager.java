package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Pais;
import com.kenny.app.repository.PaisDao;
@Component
public class SimplePaisManager implements PaisManager{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PaisDao paisDao;
	@Override
	public List<Pais> getPaises() {
		// TODO Auto-generated method stub
		return this.paisDao.getListPaises();
	}
	

}
