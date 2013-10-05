package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Objetivo;
import com.kenny.app.repository.ObjetivoDao;
@Component
public class SimpleObjetivoManager implements ObjetivoManager {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Autowired
private ObjetivoDao objetivodao;
	@Override
	public List<Objetivo> getObjetivosProyecto(int proyecto_id) {
		// TODO Auto-generated method stub
		return this.objetivodao.getObjetivoList(proyecto_id);
	}

	@Override
	public Objetivo save(Objetivo objetivo) {
		// TODO Auto-generated method stub
		return this.objetivodao.save(objetivo);
	}

	@Override
	public void actualizarCodigos(int codigo , int tipo) {
		this.objetivodao.actualizarCodigos(codigo,tipo);
		
	}

	@Override
	public int eliminar(int objetivo_id) {
		return this.objetivodao.eliminar(objetivo_id);
		
	}

	@Override
	public Objetivo getById(int objetivo_id) {
		// TODO Auto-generated method stub
		return this.objetivodao.getById(objetivo_id);
	}
	

}
