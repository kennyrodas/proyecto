package com.kenny.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Supuesto;
import com.kenny.app.repository.SupuestoDao;
@Component
public class SimpleSupuestoManager implements SupuestoManager{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SupuestoDao supuestoDao;
	@Override
	public Supuesto save(Supuesto supuesto) {
		return this.supuestoDao.save(supuesto);
	}

}
