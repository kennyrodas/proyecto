package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Proyecto;
import com.kenny.app.repository.ProyectoDao;;

@Component
public class SimpleProyectoManager implements ProyectoManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProyectoDao proyectoDao;

	@Override
	public List<Proyecto> getProyectosList() {
		// TODO Auto-generated method stub
		return this.proyectoDao.getProyectoList();
	}

	@Override
	public Proyecto save(Proyecto proyecto) {
		return this.proyectoDao.saveProyecto(proyecto);
		
	}

	@Override
	public Proyecto getById(int id) {
		return this.proyectoDao.getProyectoById(id);
		
	}
}
