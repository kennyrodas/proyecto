package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.PerfilUsuario;
import com.kenny.app.repository.PerfilUsuarioDao;
@Component
public class SimplePerfilUsuarioManager implements PerfilUsuarioManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PerfilUsuarioDao perfilUsuarioDao;
	@Override
	public List<PerfilUsuario> getPerfiles() {
		// TODO Auto-generated method stub
		return this.perfilUsuarioDao.getPerfilesList();
	}

}
