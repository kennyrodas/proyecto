package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.MedioVerificacion;
import com.kenny.app.repository.MedioVerificacionDao;
@Component
public class SimpleMedioVerificacionManager implements
		MedioVerificacionManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Autowired
private MedioVerificacionDao mediodao;
	@Override
	public List<MedioVerificacion> getMedioByIndicador(int indicador_id) {
		// TODO Auto-generated method stub
		return this.mediodao.getMediosByIndicador(indicador_id);
	}

	@Override
	public MedioVerificacion save(MedioVerificacion verificacion) {
		// TODO Auto-generated method stub
		return this.mediodao.save(verificacion);
	}

}
