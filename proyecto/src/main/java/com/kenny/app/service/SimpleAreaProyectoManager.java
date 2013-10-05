package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kenny.app.domain.AreaProyecto;
import com.kenny.app.repository.AreaProyectoDao;

@Component
public class SimpleAreaProyectoManager implements AreaProyectoManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private AreaProyectoDao areaProyectoDao;
	public AreaProyectoDao getAreaProyectoDao() {
		return areaProyectoDao;
	}
	public void setAreaProyectoDao(AreaProyectoDao areaProyectoDao) {
		this.areaProyectoDao = areaProyectoDao;
	}

	@Override
	public List<AreaProyecto> getAreasProyecto() {
		// TODO Auto-generated method stub
		return areaProyectoDao.getAreaProyectoList();
	}

}
