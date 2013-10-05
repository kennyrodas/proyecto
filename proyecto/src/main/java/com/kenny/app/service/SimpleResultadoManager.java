package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Resultado;
import com.kenny.app.repository.DistritoDao;
import com.kenny.app.repository.ResultadoDao;
@Component

public class SimpleResultadoManager implements ResultadoManager{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ResultadoDao resultadoDao;
	@Override
	public List<Resultado> getResultadosByProyecto(int proyecto_id) {
		// TODO Auto-generated method stub
		return resultadoDao.getResultadosByProyecto(proyecto_id);
	}

}
