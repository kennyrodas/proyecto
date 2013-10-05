package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.ProyectoUsuario;
import com.kenny.app.repository.ProyectoUsuarioDao;
@Component
public class SimpleProyectoUsuarioManager implements ProyectoUsuarioManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProyectoUsuarioDao proyectoUsuarioDao;
	@Override
	public List<ProyectoUsuario> getUsuariosProyecto(int proyecto_id) {
		// TODO Auto-generated method stub
		return this.proyectoUsuarioDao.getProyectoUsuarioList(proyecto_id);
	}
	@Override
	public ProyectoUsuario save(ProyectoUsuario pu) {
		return this.proyectoUsuarioDao.save(pu);
		
	}

}
