package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Indicador;
import com.kenny.app.repository.IndicadorDao;
@Component
public class SimpleIndicadorManager implements IndicadorManager {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Autowired
private IndicadorDao indicadordao;
	@Override
	public List<Indicador> getIndicadoresObjetivo(int objetivo_id) {
		// TODO Auto-generated method stub
		return this.indicadordao.getIndicadoresList(objetivo_id);
	}

	@Override
	public Indicador save(Indicador indicador) {
		// TODO Auto-generated method stub
		return this.indicadordao.saveIndicador(indicador);
	}

}
