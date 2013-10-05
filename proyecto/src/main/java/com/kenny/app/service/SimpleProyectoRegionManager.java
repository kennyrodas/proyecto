package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.ProyectoRegion;
import com.kenny.app.repository.ProyectoRegionDao;
@Component
public class SimpleProyectoRegionManager implements ProyectoRegionManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProyectoRegionDao proyectoRegionDao;
	@Override
	public List<ProyectoRegion> getRegionesProyecto(int proyecto_id) {
		// TODO Auto-generated method stub
		return this.proyectoRegionDao.getProyectoRegionList(proyecto_id);
	}
	@Override
	public ProyectoRegion save(ProyectoRegion pu) {
		return this.proyectoRegionDao.save(pu);
		
	}

}
